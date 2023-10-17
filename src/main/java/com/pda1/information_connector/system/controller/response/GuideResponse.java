package com.pda1.information_connector.system.controller.response;

import com.pda1.information_connector.system.service.dto.GuideDTO;
import lombok.*;

import java.util.ArrayList;
import java.util.List;


@Getter
public class GuideResponse {

    private List<GuideDTO> response = new ArrayList<>();

}
