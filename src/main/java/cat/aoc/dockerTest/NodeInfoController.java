package cat.aoc.dockerTest;

import java.net.InetAddress;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class NodeInfoController {

	@Autowired
	private ConfigProperties configProps;
	
    @GetMapping("/node")
    public String getNodeInfo(Model model) throws Exception {
    	InetAddress localhost = java.net.InetAddress.getLocalHost();
    	String hostName = localhost.getHostName();
    	
        model.addAttribute("name", hostName);
        model.addAttribute("buildVersion", configProps.getBuildVersion());
        
        return "node";
    }

}