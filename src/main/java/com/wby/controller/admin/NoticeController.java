package com.wby.controller.admin;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import com.wby.entity.Notice;
import com.wby.service.NoticeService;
import com.wby.util.DateUtil;
import org.apache.commons.io.FileUtils;
import javax.annotation.Resource;
import java.io.File;
import java.util.*;

/**
 * Created with IDEA
 * Author:wangboyue
 * Date:2019/3/20 0020
 * Time:21:23
 **/

@RequestMapping("/admin/notice")
@RestController
public class NoticeController {

    @Resource
    NoticeService noticeService;

    @Value("${imageFilePath}")
    private String imageFilePath;


    /**
     * 保存公告
     * @param notice
     * @return
     * @throws Exception
     */
    @RequestMapping("/saveNotice")
    public Map<String,Object> saveNotice(Notice notice) throws Exception {


//        if(!file.isEmpty()){
//
//            String fileName=file.getOriginalFilename(); // 获取文件名
//            String suffixName=fileName.substring(fileName.lastIndexOf(".")); // 获取文件的后缀
//            String newFileName= DateUtil.getCurrentDateStr()+suffixName;
//            FileUtils.copyInputStreamToFile(file.getInputStream(), new File(imageFilePath+newFileName));
//            System.out.println(fileName+"||"+newFileName);
//
//        }

        Map<String, Object> map = new HashMap<>();
        notice.setUploadDate(new Date());
        noticeService.saveNotice(notice);
        map.put("success",true);
        return map;

    }


    /**
     * 上传
     * @param file
     * @param CKEditorFuncNum
     * @return
     * @throws Exception
     */
    @PostMapping("/ckeditorUpload")
    public String ckeditorUpload(@RequestParam("upload")MultipartFile file,String CKEditorFuncNum)throws Exception{
        String fileName=file.getOriginalFilename(); // 获取文件名
        String suffixName=fileName.substring(fileName.lastIndexOf(".")); // 获取文件的后缀
        String newFileName=DateUtil.getCurrentDateStr()+suffixName;
        FileUtils.copyInputStreamToFile(file.getInputStream(), new File(imageFilePath+newFileName));
        System.out.println("1111");
        StringBuffer sb=new StringBuffer();
        sb.append("<script type=\"text/javascript\">");
        sb.append("window.parent.CKEDITOR.tools.callFunction("+ CKEditorFuncNum + ",'" +"/static/images"+ newFileName + "','')");
        sb.append("</script>");

        return sb.toString();

    }


    /**
     * 查询公告
     * @param notice
     * @param page
     * @param rows
     * @return
     */
    @RequestMapping("/listAll")
    public Map<String,Object>findAllNotice(Notice notice, @RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "rows", required = false) Integer rows){

        Map<String, Object> map = new HashMap<>();
        List<Notice> noticeList = noticeService.noticeList(notice,page,rows, Sort.Direction.DESC, "id");
        Long total = noticeService.getTotalCount(notice);
        map.put("rows", noticeList);
        map.put("total", total);
        return map;
    }

    /**
     * 删除公告信息
     * @return
     */
    @RequestMapping("/deleteNotice")
    public Map<String,Object>deleteNotice(@RequestParam(value = "ids") String ids){

        String []idsString = ids.split(",");
        for (int i=0;i<idsString.length;i++){
            Integer noticeId=Integer.parseInt(idsString[i]);
            noticeService.deleteNotice(noticeId);
        }
        Map<String, Object> map = new HashMap<>();
        map.put("success",true);
        return map;
    }

    @RequestMapping("/findNoticeById")
    public Optional<Notice> findNoticeById(Integer id){
        return noticeService.findById(id);
    }
}
