package com.cars24.csms.services;

import com.cars24.csms.data.req.CreateServiceReq;
import com.cars24.csms.data.req.UpdateServiceReq;
import com.cars24.csms.data.resp.ApiResponse;
import com.cars24.csms.data.resp.CreateServiceResponse;
import com.cars24.csms.data.resp.UpdateServiceResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface VehicleServiceManagementService {
    ResponseEntity<CreateServiceResponse> createService(CreateServiceReq createServiceReq);
    ResponseEntity<UpdateServiceResponse> updateService(Integer id, UpdateServiceReq updateServiceReq);
    int deleteService(Integer id);
CreateServiceResponse getServiceByID(int id);

//    //GetServiceRes getService(GetServiceReq getServiceReq);
//
}
