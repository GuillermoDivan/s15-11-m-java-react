package com.s1511.ticketcine.domain.services;

import com.s1511.ticketcine.application.dto.login.RequestLogin;
import com.s1511.ticketcine.application.dto.login.ResponseLogin;

public interface AuthenticationService {
        ResponseLogin login(RequestLogin data);
}
