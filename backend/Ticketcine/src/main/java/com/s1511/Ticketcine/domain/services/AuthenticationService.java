package com.s1511.Ticketcine.domain.services;

import com.s1511.Ticketcine.application.dto.login.RequestLogin;
import com.s1511.Ticketcine.application.dto.login.ResponseLogin;

public interface AuthenticationService {
        ResponseLogin login(RequestLogin data);
}
