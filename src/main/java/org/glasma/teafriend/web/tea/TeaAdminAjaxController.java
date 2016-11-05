package org.glasma.teafriend.web.tea;

import org.glasma.teafriend.model.Tea;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ajax/admin/teas")
public class TeaAdminAjaxController extends AbstractTeaController{

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable int id) {super.delete(id);}

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public void save(@RequestParam int id,
                     @RequestParam String name,
                     @RequestParam String category,
                     @RequestParam String country,
                     @RequestParam String description) {
        Tea tea = new Tea(id, name, category, country, description);
        if (id == 0)
            super.create(tea);
        else
            super.update(tea);
    }
}
