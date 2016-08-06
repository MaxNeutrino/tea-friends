package org.glasma.teafriend.web.tea;

import org.glasma.teafriend.model.Tea;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.Objects;

@Controller
@RequestMapping("/teas")
public class JspTeaController extends AbstractTeaController {

    @RequestMapping(method = RequestMethod.GET)
    public String teaList(Model model) {
        model.addAttribute("teaList", super.getAll());
        return "teaList";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String delete(HttpServletRequest request) {
        super.delete(getId(request));
        return "redirect:/teas";
    }

    @RequestMapping(value = "/update", method = RequestMethod.GET)
    public String editForUpdate(HttpServletRequest request, Model model) {
        model.addAttribute("tea", super.get(getId(request)));
        return "teaEdit";
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String editForCreate(Model model) {
        model.addAttribute("tea", new Tea());
        return "teaEdit";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String updateOrCreate(HttpServletRequest request, Model model) {
        String id = request.getParameter("id");
        Tea tea = new Tea(id.isEmpty() ? null : Integer.valueOf(id),
                request.getParameter("name"),
                request.getParameter("category"),
                request.getParameter("country"),
                request.getParameter("description"));
        if (tea.isNew()) {
            super.create(tea);
        } else {
            super.update(tea);
        }
        return "redirect:/teas";
    }

    @RequestMapping(value = "/filter", method = RequestMethod.POST)
    public String getFilteredList (HttpServletRequest request, Model model) {
        String category = request.getParameter("category");
        String country = request.getParameter("country");
        model.addAttribute("teaList", super.getFilteredList(category, country));
        return "teaList";
    }

    @RequestMapping(value = "/name", method = RequestMethod.GET)
    public String getByName (HttpServletRequest request, Model model) {
        String name = request.getParameter("name");
        model.addAttribute("tea", super.getByName(name));
        return "tea";
    }

    private int getId(HttpServletRequest request) {
        String paramId = Objects.requireNonNull(request.getParameter("id"));
        return Integer.valueOf(paramId);
    }
}
