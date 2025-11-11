package com.senai.Flora.Infrastructure.jwt;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
@RequiredArgsConstructor
public class JwtAuthFilter extends OncePerRequestFilter {

    private final JwtUtil jwtUtil;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        String authHeader = request.getHeader("Authorization");

        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            response.setContentType("application/json");
            response.getWriter().write("{\"error\": \"Acesso negado! Token ausente ou mal formatado.\"}");
            return;
        }
            String token = authHeader.substring(7);

            try { // * vai extrair o e-mail e verificar se o token é valido
                String email = jwtUtil.getEmailFromToken(token);
                if (email == null || email.isEmpty()) {
                    throw new RuntimeException("Token inválido");
                }

                request.setAttribute("UserEmail", email); // * token valido entao vai seguir o fluxo


            }catch (io.jsonwebtoken.ExpiredJwtException e){
                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                response.setContentType("application/json");
                response.getWriter().write("{\"error\": \"Token expirado. Faça login novamente.\"}");
                return;

            }catch (Exception e){
                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                response.setContentType("application/json");
                response.getWriter().write("{\"error\": \"Token inválido ou corrompido.\"}");
                return;
            }

        filterChain.doFilter(request, response);
    }


}
