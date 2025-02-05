package com.cars24.csms.controller;

import com.cars24.csms.data.req.CreateServiceReq;
import com.cars24.csms.data.req.UpdateServiceReq;
import com.cars24.csms.data.resp.CreateServiceResponse;
import com.cars24.csms.data.resp.UpdateServiceResponse;
import com.cars24.csms.services.impl.VehicleServiceManagementServiceImpl;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/services")
@RequiredArgsConstructor
@Validated
@Slf4j

@Service
public class ServicesController {

    @Autowired
    private final VehicleServiceManagementServiceImpl vsi;
    //private static final Logger log= LoggerFactory.getLogger(ServicesController.class);
    //VehicleServiceManagementService s;

    @PostMapping
    public ResponseEntity<CreateServiceResponse> CreateService(@Valid @RequestBody CreateServiceReq createServiceReq){

        CreateServiceResponse serv= new CreateServiceResponse();
        ResponseEntity<CreateServiceResponse> cr=vsi.createService(createServiceReq);
        log.info("[createService] createServiceReq{}", createServiceReq);
        //vsi.createService(createServiceReq);
        return cr;
    }
@DeleteMapping("/{id}")
public ResponseEntity<Integer> DeleteService(@PathVariable Integer id){
    //System.out.println("[createService] createServiceReq{}"+deleteServiceReq);
    //DeleteServiceResponse serv= new DeleteServiceResponse();
    log.info("[deleteService] id{}", id);
    vsi.deleteService(id);
    return ResponseEntity.ok(id) ;
}
@GetMapping("/{id}")
public ResponseEntity<CreateServiceResponse> getServiceByID(@PathVariable int id){
    log.info("fetching services with id {}",id);
    CreateServiceResponse createServiceResponse = vsi.getServiceByID(id);
    return ResponseEntity.ok(createServiceResponse);
}
//
@PutMapping("/{id}")
public ResponseEntity<UpdateServiceResponse>UpdateService(@PathVariable Integer id,@Valid @RequestBody UpdateServiceReq updateServiceReq){
        log.info("[UpdateService]UpdateServiceReq{}",updateServiceReq);

    ResponseEntity<UpdateServiceResponse> updateServiceResponse=vsi.updateService(id,updateServiceReq);

    return updateServiceResponse;

}


//@GetMapping("/by-name")
//public ResponseEntity<GetServiceRes> getServiceByName(@Valid @RequestBody GetServiceReq getServiceReq) {
//    log.info("[getService] Fetching service with name: {}", getServiceReq);
//    GetServiceRes service = s.getServiceByName(getServiceReq.getName()); // Call service layer
//    return ResponseEntity.ok().body(service);
//}



//@PutMapping("/{id}")
//public ResponseEntity<UpdateServiceResponse>UpdateService(@PathVariable Integer id,@Valid @RequestBody UpdateServiceReq updateServiceReq){
//        log.info("[UpdateService]UpdateServiceReq{}",updateServiceReq);
//    UpdateServiceResponse serv= new UpdateServiceResponse();
//vsi.updateService(id,updateServiceReq);
//
//    return ResponseEntity.ok().body(serv);
//
//}

}
