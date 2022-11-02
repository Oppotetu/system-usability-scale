package com.sus.app.systemUsabilityScale.controllers;

import com.sus.app.systemUsabilityScale.services.ComputeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class SessionController {

/*    @GetMapping("/page-one")
    public String pageOne(HttpSession httpSession) {
        httpSession.setAttribute("txId", "tx1234");
        return "page-one";
    }

    @GetMapping("/page-two")
    public String pageTwo(HttpSession httpSession) {
        String strCheck = "tx1234";
        String txIdSession = httpSession.getAttribute("txId").toString();
        if (txIdSession.equals(txId)) {
            httpSession.removeAttribute("txId");
        }
        return "page-two";
    }*/

    @Autowired
    ComputeService computeService;

/*    @PostMapping("/scales")
    private int saveScale(@RequestBody Scale scale) {
        scaleService.saveScale(scale);
        return scale.getQ2();
    }*/


/*    @GetMapping("/color")
    public String index(Model model, HttpSession session) {
        List<String> favoriteColors = getFavColors(session);
        model.addAttribute("favoriteColors", favoriteColors);
        model.addAttribute("sessionId", session.getId());
        return "index";
    }

    @PostMapping("/saveColor")
    public String saveMessage
            (@RequestParam("color") String color,
             HttpServletRequest request) {

        List<String> favoriteColors
                =getFavColors(request.getSession());
        if (StringUtils.hasLength(color)) {
            favoriteColors.add(color);
            request.getSession().
                    setAttribute("favoriteColors", favoriteColors);
        }
        return "redirect:/color";
    }

    private List<String> getFavColors(HttpSession session) {
        List<String> favoriteColors = (List<String>) session
                .getAttribute("favoriteColors");

        if (favoriteColors == null) {
            favoriteColors = new ArrayList<>();
        }
        return favoriteColors;
    }*/
}
