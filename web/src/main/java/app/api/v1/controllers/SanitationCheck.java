package app.api.v1.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(value = "Sanitation Check", description = "displays a simple string on a successful connection.")
@RestController
public class SanitationCheck
{
    @ApiOperation(value = "returns a simple string.")
    @GetMapping("/")
    public String sanitationCheck()
    {
        return "connected to the Catering API.";
    }
}
