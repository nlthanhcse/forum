package ojt.thanhnl4.categoryservice.feignService;

import ojt.thanhnl4.categoryservice.dto.UserDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name = "user-service")
public interface UserFeignService {
    @GetMapping("/api/")
    public List<UserDTO> getAll();
}
