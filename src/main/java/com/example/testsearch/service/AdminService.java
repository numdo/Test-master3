package com.example.testsearch.service;

import com.example.testsearch.dto.Data;
import com.example.testsearch.dto.FileDto;
import com.example.testsearch.mapper.AdminMapper;
import com.example.testsearch.mapper.CommonMapper;
import com.example.testsearch.mapper.FileMapper;
import com.example.testsearch.util.FileUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class AdminService {

    private static final Logger logger = (Logger) LogManager.getLogger(SearchService.class);

    private AdminMapper adminMapper;
    private CommonMapper commonMapper;
    private FileUtil fileUtil;
    private FileMapper fileMapper;

    public AdminService(AdminMapper adminMapper, CommonMapper commonMapper, FileUtil fileUtil, FileMapper fileMapper) {
        this.adminMapper = adminMapper;
        this.commonMapper = commonMapper;
        this.fileUtil = fileUtil;
        this.fileMapper = fileMapper;
    }

    /* data 등록 처리 */
    public int addData(Data data, String sessionId, MultipartFile[] fileImage, String fileRealPath){

        String code = commonMapper.getNewCode("Data_Code", "data");
        data.setData_Code(code);
        data.setUserId(sessionId);

        int result = adminMapper.addData(data);

        List<FileDto> fileList = fileUtil.parseFileInfo(fileImage, fileRealPath);

        fileMapper.addFiles(fileList);

        List<Map<String, String>> paramList = new ArrayList<Map<String, String>>();

        Map<String, String> paramMap = null;

        for(FileDto fileDto : fileList){
            paramMap = new HashMap<String, String>();
            paramMap.put("referenceCode", code);
            paramMap.put("fileIdx", fileDto.getFileIdx());
            paramList.add(paramMap);
        }
        fileMapper.addFileControl(paramList);

        return result;

    }



}
