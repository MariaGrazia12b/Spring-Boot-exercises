package com.example.Esercizio4;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;
@Tag(name = "Reverse name", description = "Espone API per recuperare il nome e il nome al contrario")
@RestController
@RequestMapping("/v1")
public class MyController {
    @Operation(
            summary = "Restituzione del nome",
            description = "Metodo che restituisce il nome ricevuto in request param",
            tags = { "name", "get" })
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = String.class), mediaType = "application/json") }),
            @ApiResponse(responseCode = "404", description = "Nessun request param ricevuto", content = { @Content(schema = @Schema()) })
    })
    @GetMapping("/name")
    public String name (@Parameter (required = true) @RequestParam String name) {
        return "Nome: " + name;
    }

    @Operation(
            summary = "Restituzione del nome al contrario utilizzando lo StringBuilder",
            description = "Metodo che restituisce il nome al contrario ricevuto in request body",
            tags = { "reverse-name", "post" })
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = String.class), mediaType = "application/json") }),
            @ApiResponse(responseCode = "404", description = "Nessun request param ricevuto", content = { @Content(schema = @Schema()) })
    })
    @PostMapping("/reverse-nome")
    public String reverseName (@Parameter(description = "Nome che verrà restituito capovolto") @RequestBody String name) {
        StringBuilder reversedName = new StringBuilder(name).reverse();
        return "Nome al contrario: " + reversedName.toString();
    }
}
