package com.school.management.controller.info;

import com.school.management.common.core.controller.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/info/score")
public class ScoreController extends BaseController {

    private String prefix = "info/score";

    @GetMapping()
    public String score(ModelMap map)
    {
        return prefix + "/score";
    }
}
