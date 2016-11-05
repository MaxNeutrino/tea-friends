package org.glasma.teafriend.web.tea;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/teas")
public class JspTeaController extends AbstractTeaController {

    @RequestMapping(method = RequestMethod.GET)
    public String teaList(Model model) {
        model.addAttribute("teaList", super.getAll());
        return "teaList";
    }

    /*@RequestMapping(value = "/tea", method = RequestMethod.GET)
    public String getTea(HttpServletRequest request, Model model) {
        model.addAttribute("tea", super.get(getId(request)));
        return "teaInfo";
    }*/


    @RequestMapping(value = "/filter", method = RequestMethod.POST)
    public String getFilteredList (HttpServletRequest request, Model model) {
        String category = request.getParameter("category");
        String country = request.getParameter("country");
        model.addAttribute("teaList", super.getFilteredList(category, country));
        return "teaList";
    }

    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public String searchByName(HttpServletRequest request, Model model) {
        String name = request.getParameter("name");
        model.addAttribute("teaList", super.searchTeaByName(name));
        return "teaList";
    }
}
