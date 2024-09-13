package backend.spring.task3.controller;

import backend.spring.task3.model.Employee;
import backend.spring.task3.repository.EmployeeRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.hibernate.query.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("")
public class EmployeeController {

    private final EmployeeRepository employeeRepository;

    @Operation(summary = "Get All Employees")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Employee List",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Iterable.class)) }),
            @ApiResponse(responseCode = "204",
                    description = "No employee found",
                    content = @Content) })
    @Tag(description = "EmployeeController", name = "My Employee")
    @GetMapping("/employees")
    public Iterable<Employee> findAllEmployees(String filter) {
        return this.employeeRepository.findAll();
    }

    @PostMapping("/employees")
    @Tag(description = "EmployeeController", name = "My Employee")
    public Employee addOneEmployee(@RequestBody Employee employee) {
        return this.employeeRepository.save(employee);
    }


}
