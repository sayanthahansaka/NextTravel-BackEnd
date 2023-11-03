package com.sayantha.packageservicea.service.impl.custom.impl;



import com.sayantha.packageservicea.dto.PackageDTO;
import com.sayantha.packageservicea.entity.PackagesDetails;
import com.sayantha.packageservicea.interfaces.PackageFiegnInterfaec;
import com.sayantha.packageservicea.repo.PackageRepo;
import com.sayantha.packageservicea.service.impl.custom.PackageService;
import com.sayantha.packageservicea.util.Response;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
@Transactional
public class PackageService_impl implements PackageService {

    @Autowired
    private PackageRepo packageRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private Response response;



    //Rest templet for communication other servers
    //Fientclient , Service Discovery we use

    @Autowired
    private PackageFiegnInterfaec packageFiegnInterfaec;






    //-------------------------------------------------------



    @Override
    public ResponseEntity<Response>  search(String id) {
        Optional<PackagesDetails>packageEntity=packageRepo.findById(id);
        if (packageEntity.isPresent()){
            return createAndSendResponse(HttpStatus.OK.value() ,"success",modelMapper.map(packageEntity.get(),PackageDTO.class));
        }
        return createAndSendResponse(HttpStatus.NOT_FOUND.value(),"eorr",null);
    }

    @Override
    public ResponseEntity<Response> save(PackageDTO packageDto) {
        if (search(packageDto.getPackage_id()).getBody().getData()==null){
            packageRepo.save(modelMapper.map(packageDto, PackagesDetails.class));
            return createAndSendResponse(HttpStatus.OK.value(),"Save OK",null);
        }
        throw new RuntimeException(" no save Package");
    }

    @Override
    public ResponseEntity<Response>  update(PackageDTO packageDto) {
        if (search(packageDto.getPackage_id()).getBody().getData() !=null){
            packageRepo.save(modelMapper.map(packageDto, PackagesDetails.class));
            return createAndSendResponse(HttpStatus.OK.value() ,"Update OK!",null);
        }
        return createAndSendResponse(HttpStatus.NOT_FOUND.value(), "Package not found!", null);

    }

    @Override
    public ResponseEntity<Response>  delete(String id) {
        if (search(id).getBody().getData()!=null){
        packageRepo.deleteById(id);
        return createAndSendResponse(HttpStatus.OK.value(),"Delete OK",null);
        }
        return createAndSendResponse(HttpStatus.NOT_FOUND.value(), "Package not found!", null);
    }

    @Override
    public ResponseEntity<Response>  getAll() {
        List<PackagesDetails>pkgEntities=packageRepo.findAll();
        if (!pkgEntities.isEmpty()){
            List<PackageDTO>pkg_Dtos=new ArrayList<>();
            pkgEntities.forEach(packgeEntity -> {
                pkg_Dtos.add(modelMapper.map(packgeEntity,PackageDTO.class));
            });
            return createAndSendResponse(HttpStatus.OK.value(),"Success Package",pkg_Dtos);
        }
        return createAndSendResponse(HttpStatus.NOT_FOUND.value(),"No success",null);
    }

    @Override
    public ResponseEntity<Response> createAndSendResponse(int statusCode, String msg, Object data) {
        response.setStatusCode(statusCode);
        response.setMessage(msg);
        response.setData(data);
        System.out.println("Status Code : " + statusCode);
        System.out.println("Sent : " + HttpStatus.valueOf(statusCode));

        return new ResponseEntity<>(response, HttpStatus.valueOf(statusCode));

    }


    @Override
    public ResponseEntity<Response> addHotel(String packageID, String hotelID) {
        Optional<PackagesDetails> pack = packageRepo.findById(packageID);
        if (pack.isPresent()) {
            pack.get().getHotel_Category().add(hotelID);
            return createAndSendResponse(HttpStatus.OK.value(), "Hotel added successfully!", null);

        }
        return createAndSendResponse(HttpStatus.NOT_FOUND.value(), "Package does not exist!", null);
    }

    @Override
    public ResponseEntity<Response> deleteHotel(String packageID, String hotelID) {
        Optional<PackagesDetails> pack = packageRepo.findById(packageID);
        if (pack.isPresent()) {
            pack.get().getHotel_Category().remove(hotelID);
            return createAndSendResponse(HttpStatus.OK.value(), "Hotel deleted successfully!", null);

        }
        return createAndSendResponse(HttpStatus.NOT_FOUND.value(), "Package does not exist!", null);
    }
    @Override
    public ResponseEntity<Response> addVehicle(String packageID, String vehicleID) {
        Optional<PackagesDetails> pack = packageRepo.findById(packageID);
        if (pack.isPresent()) {
            pack.get().getVehical_Category().add(vehicleID);
            return createAndSendResponse(HttpStatus.OK.value(), "Vehicle added successfully!", null);

        }
        return createAndSendResponse(HttpStatus.NOT_FOUND.value(), "Package does not exist!", null);
    }

    @Override
    public ResponseEntity<Response> deleteVehicle(String packageID, String vehicleID) {
        Optional<PackagesDetails> pack = packageRepo.findById(packageID);
        if (pack.isPresent()) {
            pack.get().getVehical_Category().remove(vehicleID);
            return createAndSendResponse(HttpStatus.OK.value(), "Vehicle deleted successfully!", null);

        }
        return createAndSendResponse(HttpStatus.NOT_FOUND.value(), "Package does not exist!", null);
    }

    @Override
    public List<String> getHotelsList(String packageID) {
        Optional<PackagesDetails> pack = packageRepo.findById(packageID);
        if (pack.isPresent()) {
            System.out.println("ServiceIMPL HIDS : "+pack.get().getHotel_Category());
            return pack.get().getHotel_Category();
        }
        throw new RuntimeException("Package does not exist!");
    }

    @Override
    public ResponseEntity<Response> getPackageByCategory(String category) {
        Optional<PackagesDetails> pack = packageRepo.findByPackageCategory(category);
        if (pack.isPresent()) {
            return createAndSendResponse(HttpStatus.OK.value(), "Package retrieved successfully!", modelMapper.map(pack.get(), PackageDTO.class));
        }
        return createAndSendResponse(HttpStatus.NOT_FOUND.value(), "Package does not exist!", null);
    }


    @Override
    public List<String> getPackageCategoryList() {
        List<PackagesDetails> packages = packageRepo.findAll();
        List<String> categories = packages.stream()
                .map(PackagesDetails::getPackageCategory)
                .distinct()
                .collect(Collectors.toList());
        return categories;
    }

    @Override
    public List<String> getVehiclesList(String packageID) {
        Optional<PackagesDetails> pack = packageRepo.findById(packageID);
        if (pack.isPresent()) {
            System.out.println("ServiceIMPL VIDS : "+pack.get().getVehical_Category());
            return pack.get().getVehical_Category();

        }
        throw new RuntimeException("Package does not exist!");
    }


//    @Override
//    public List<String> getAllID() {
//        List<String> allIDs= packageRepo.getAllID();
//        System.out.println(allIDs);
//        return allIDs;
//    }


    @Override
    public ResponseEntity<Response> updateHotelPackageID(String oldPackageId, String newPackageId, String hotelId) {
        Optional<PackagesDetails> oldPackage = packageRepo.findById(oldPackageId);
        if(oldPackage.isPresent()){
            oldPackage.get().getHotel_Category().remove(hotelId);
            Optional<PackagesDetails> newPackage = packageRepo.findById(newPackageId);
            if(newPackage.isPresent()){
                newPackage.get().getHotel_Category().add(hotelId);
                return createAndSendResponse(HttpStatus.OK.value(),"Hotel and Package updated successfully!",null);

            }
            return createAndSendResponse(HttpStatus.NOT_FOUND.value(),"New Package does not exist!",null);


        }
        return createAndSendResponse(HttpStatus.NOT_FOUND.value(),"Old Package does not exist!",null);


    }

    @Override
    public ResponseEntity<Response> updateVehiclePackageID(String oldPackageId, String newPackageId, String vehicleId) {
        Optional<PackagesDetails> oldPackage = packageRepo.findById(oldPackageId);
        if(oldPackage.isPresent()){
            oldPackage.get().getVehical_Category().remove(vehicleId);
            Optional<PackagesDetails> newPackage = packageRepo.findById(newPackageId);
            if(newPackage.isPresent()){
                newPackage.get().getVehical_Category().add(vehicleId);
                return createAndSendResponse(HttpStatus.OK.value(),"Vehicle and Package updated successfully!",null);

            }
            return createAndSendResponse(HttpStatus.NOT_FOUND.value(),"New Package does not exist!",null);
        }
        return createAndSendResponse(HttpStatus.NOT_FOUND.value(),"Old Package does not exist!",null);
    }

/*    @Override
    public ResponseEntity<Response> getPackageByCategory(String category) {
        Optional<Package_entity> pack = packageRepo.(category);
        if(pack.isPresent()){
            return createAndSendResponse(HttpStatus.OK.value(),"Package retrieved successfully!",mapper.map(pack.get(),PackagesDTO.class));

        }
        return createAndSendResponse(HttpStatus.NOT_FOUND.value(),"Package does not exist!",null);

    }*/

/*    @Override
    public List<String> getPackageCategoryList() {
        return    packageRepo.findByPackageCategory();
    }*/
    // testing
/*
    public ResponseEntity<String> createVehicles(@RequestBody String id) {
        // You should pass the id to your Feign client to retrieve vehicle data
        List<String> vehicles = Collections.singletonList(packageFiegnInterfaec.getAllVehicles(id).getBody());

        Package_entity packageEntity=new Package_entity();
        packageEntity.setVehical_Category(Collections.singletonList("V0124445"));
        // Here you can add logic to process the 'vehicles' data
        packageRepo.save(packageEntity);

        // If creation is successful, return a success response
        return new ResponseEntity<>("Success", HttpStatus.CREATED);
    }
*/






}
