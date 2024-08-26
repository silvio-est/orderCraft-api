package ordercraft.com.order_management.infrastructure.adapters.input.rest;

import lombok.RequiredArgsConstructor;
import ordercraft.com.order_management.application.ports.input.DishManagementServicePort;
import ordercraft.com.order_management.infrastructure.adapters.input.rest.mapper.DishManagementControllerMapper;
import ordercraft.com.order_management.infrastructure.adapters.input.rest.model.DishRequest;
import ordercraft.com.order_management.infrastructure.adapters.input.rest.model.DishResponse;
import ordercraft.com.order_management.infrastructure.adapters.input.rest.model.EditDishRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/dishes")
@CrossOrigin(origins = "http://localhost:4200")
public class DishManagementController {

    private final DishManagementServicePort dishManagementServicePort;
    private final DishManagementControllerMapper mapper;

    @PostMapping("/add")
    public ResponseEntity<HttpStatus> addDish(@RequestBody DishRequest dishRequest){

        dishManagementServicePort.addDish(mapper.toDishResponse(dishRequest));

        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @PutMapping("/edit/{dishId}")
    public ResponseEntity<HttpStatus> edithDish(@PathVariable Long dishId, @RequestBody EditDishRequest editDishRequest){

        dishManagementServicePort.editDish(dishId, mapper.toDishResponse(editDishRequest));

        return ResponseEntity.status(HttpStatus.OK).build();

    }

    @DeleteMapping("/delete/{dishId}")
    public ResponseEntity<HttpStatus> deleteDish(@PathVariable Long dishId){

        dishManagementServicePort.deleteDish(dishId);

        return ResponseEntity.status(HttpStatus.OK).build();

    }

    @GetMapping("/getDishesAvailable")
    public ResponseEntity<List<DishResponse>> getDishesAvailable(){

        return ResponseEntity.ok(
                mapper.toDishResponseList(dishManagementServicePort.getDishesAvailable())
        );
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<DishResponse>> getAllDishes(){

        return ResponseEntity.ok(
                mapper.toDishResponseList(dishManagementServicePort.getAllDishes())
        );
    }
    @GetMapping("/get/{dishId}")
    public ResponseEntity<DishResponse> getDish(@PathVariable Long dishId){

        return ResponseEntity.ok(
                mapper.toDishResponse(dishManagementServicePort.getDishByID(dishId))
        );
    }
}
