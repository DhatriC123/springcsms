package com.cars24.csms.services.impl;


import com.cars24.csms.data.dao.Impl.ServicesDaoImpl;
import com.cars24.csms.data.entities.ServicesEntity;
import com.cars24.csms.data.req.CreateServiceReq;
import com.cars24.csms.data.req.UpdateServiceReq;
import com.cars24.csms.data.resp.ApiResponse;
import com.cars24.csms.data.resp.CreateServiceResponse;
import com.cars24.csms.data.resp.UpdateServiceResponse;
import com.cars24.csms.services.VehicleServiceManagementService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class VehicleServiceManagementServiceImpl implements VehicleServiceManagementService {
    //@Autowired
    private final ServicesDaoImpl servicesDaoimpl;

    @Override
    public ResponseEntity<CreateServiceResponse> createService(CreateServiceReq createServiceReq) {
        ServicesEntity entity=servicesDaoimpl.createService(createServiceReq);
        CreateServiceResponse csr = new CreateServiceResponse();
        csr.setName(entity.getName());
        csr.setPrice(entity.getPrice());
        log.info("[createService]", createServiceReq);

        return ResponseEntity.ok().body(csr);


    }
    @Override
    public ResponseEntity<UpdateServiceResponse> updateService(Integer id,UpdateServiceReq updateServiceReq){
        ServicesEntity entity=servicesDaoimpl.updateService(id,updateServiceReq);
UpdateServiceResponse updateServiceResponse=new UpdateServiceResponse();
        updateServiceResponse.setName(entity.getName());
        updateServiceResponse.setPrice(entity.getPrice());
        return ResponseEntity.ok().body(updateServiceResponse);


//
    }
    @Override
public CreateServiceResponse getServiceByID(int id){
    return  servicesDaoimpl.getServiceByID(id);
}


@Override
    public int deleteService(Integer id){
         servicesDaoimpl.deleteService(id);
         return id;

}

//    @Override
//    public GetServiceRes getService(GetServiceReq getServiceReq) {
//        {
//            System.out.println("[getServiceByName] Fetching service with name: " + name);
//
//            // Call DAO to fetch the entity by name
//            ServicesEntity entity = servicesDaoimpl.getServiceByName(name);
//
//            // Handle if no service is found
//            if (entity == null) {
//                throw new RuntimeException("Service not found with name: " + name);
//            }
//
//            // Map the entity to the response object
//            GetServiceResp response = new GetServiceResp();
//            response.setName(entity.getName().toString()); // Convert ServiceType enum to String
//            response.setPrice(entity.getPrice());
//
//            return response;
//        }
//        return null;
//}
}
