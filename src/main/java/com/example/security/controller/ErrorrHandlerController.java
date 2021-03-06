package com.example.security.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
public class ErrorrHandlerController implements ErrorController {

    static final Logger logger = LoggerFactory.getLogger(ErrorrHandlerController.class);

    @Override
    public String getErrorPath() {
        return "/error";
    }

    @RequestMapping("/error")
    public ModelAndView renderErrorPage(HttpServletRequest httpRequest) {
        logger.debug("[ErrorrHandlerController][renderErrorPage][START]");

        ModelAndView errorPage = new ModelAndView("error_page");
        String errorMsg = "";
        int httpErrorCode = getErrorCode(httpRequest);
        logger.debug("[ErrorrHandlerController][httpErrorCode: " + httpErrorCode + "]");

        switch (httpErrorCode) {
            case 400: {
                errorMsg = "Http Error Code: 400. Bad Request";
                break;
            }
            case 401: {
                errorMsg = "Http Error Code: 401. Unauthorized";
                break;
            }
            case 403: {
                errorMsg = "Http Error Code: 403. Forbidden";
                break;
            }
            case 404: {
                errorMsg = "Http Error Code: 404. Resource not found";
                break;
            }
            case 500: {
                errorMsg = "Http Error Code: 500. Internal Server Error";
                break;
            }
        }
        errorPage.addObject("errorMsg", errorMsg);

        logger.debug("[ErrorrHandlerController][renderErrorPage][START]");
        return errorPage;
    }

    private int getErrorCode(HttpServletRequest httpRequest) {
        return (Integer) httpRequest.getAttribute("javax.servlet.error.status_code");
    }

}
