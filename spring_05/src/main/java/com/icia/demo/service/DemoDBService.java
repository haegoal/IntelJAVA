package com.icia.demo.service;


import com.icia.demo.dto.DemoDTO;
import com.icia.demo.repository.DemoDBRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DemoDBService {

    @Autowired
    private DemoDBRepository demoDBRepository;
    public void reqdb1(DemoDTO demoDTO) {
        demoDBRepository.reqdb1(demoDTO);
    }

    public List<DemoDTO> list(){
        return demoDBRepository.list();
    }

    public DemoDTO find(Long id) {
        return demoDBRepository.find(id);
    }

    public void delete(Long id) {
        demoDBRepository.delete(id);
    }

    public void update(DemoDTO demoDTO) {
        demoDBRepository.update(demoDTO);
    }
}
