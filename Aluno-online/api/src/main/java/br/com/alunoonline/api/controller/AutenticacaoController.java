package br.com.alunoonline.api.controller;

import br.com.alunoonline.api.dtos.DadosAutenticacaoDTO;
import br.com.alunoonline.api.dtos.DadosTokenJWTDTO;
import br.com.alunoonline.api.infra.security.TokenService;
import br.com.alunoonline.api.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
public class AutenticacaoController {

    @Autowired
    private AuthenticationManager manager;

    @Autowired
    private TokenService tokenService;

    @PostMapping
    public ResponseEntity<DadosTokenJWTDTO> efetuarLogin(@RequestBody DadosAutenticacaoDTO dados) {

        var authenticationToken = new UsernamePasswordAuthenticationToken(
                dados.login(),
                dados.senha()
        );

        var authentication = manager.authenticate(authenticationToken);

        var tokenJWT = tokenService.gerarToken((Usuario) authentication.getPrincipal());

        return ResponseEntity.ok(new DadosTokenJWTDTO(tokenJWT));
    }
}