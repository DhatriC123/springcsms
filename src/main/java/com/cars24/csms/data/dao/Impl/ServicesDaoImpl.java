package com.cars24.csms.data.dao.Impl;

import com.cars24.csms.data.dao.ServicesDao;

import com.cars24.csms.data.entities.ServicesEntity;
import com.cars24.csms.data.repositories.ServicesRepository;
import com.cars24.csms.data.req.CreateServiceReq;
import com.cars24.csms.data.req.UpdateServiceReq;
import com.cars24.csms.data.resp.CreateServiceResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class ServicesDaoImpl implements ServicesDao {
    @Autowired
    private final ServicesRepository repo;
    @Override
    public ServicesEntity createService(CreateServiceReq createServiceReq) {
        ServicesEntity se = new ServicesEntity();
        //se.setId(0);
        se.setName(createServiceReq.getName());
        se.setPrice(createServiceReq.getPrice());
        repo.save(se);
        log.info("[ServicesDao]", createServiceReq);
        return se;
    }

    @Override
    public  ServicesEntity updateService(Integer id,UpdateServiceReq updateServiceReq) {
        ServicesEntity se=repo.findById(id).orElse(null);
        //ServicesEntity se = new ServicesEntity();
        //se.setId(0);
        se.setName(updateServiceReq.getName());
        se.setPrice(updateServiceReq.getPrice());
        repo.save(se);
        log.info("[ServicesDao]", updateServiceReq);
        return se;
    }


@Override
    public CreateServiceResponse getServiceByID(int id){
        log.info("fetching invoice by id {}",id);
        ServicesEntity serviceEntity = repo.findById(id)
                .orElseThrow(()-> new RuntimeException());


        //return mapEntityToResponse(serviceEntity);
    CreateServiceResponse cr=mapEntityToResponse(serviceEntity);
    return cr;
    }

    private CreateServiceResponse mapEntityToResponse(ServicesEntity serviceEntity){
        CreateServiceResponse createServiceResponse = new CreateServiceResponse();
        createServiceResponse.setName(serviceEntity.getName());

        createServiceResponse.setPrice(serviceEntity.getPrice());

        return createServiceResponse;
    }
    @Override
    public Integer deleteService(Integer id){

        repo.deleteById(id);
        log.info("[ServicesDao]", id);
        return id;



    }



}


