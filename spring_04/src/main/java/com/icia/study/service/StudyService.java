package com.icia.study.service;

import com.icia.study.dto.StudyDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudyService {
    private List<StudyDTO> studyDTOList = new ArrayList<>();

    public void req1() {
        System.out.println("음메음메");
    }

    public void req2(String q1, String q2) {
        System.out.println(q1 + "\n" + q2);
    }

    public void req3(StudyDTO studyDTO) {
        studyDTOList.add(studyDTO);
        System.out.println(studyDTO);
    }


    public StudyDTO req4() {
        StudyDTO studyDTO = new StudyDTO();
        studyDTO.setP1("음ㅁ[");
        studyDTO.setP2("asas");
        studyDTO.setP3(111);
        return studyDTO;
    }

    public List<StudyDTO> req5() {
        return studyDTOList;
    }


}
