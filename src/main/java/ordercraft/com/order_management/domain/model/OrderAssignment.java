package ordercraft.com.order_management.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderAssignment {
    private Integer orderAssignmentId;
    private Integer orderId;
    private Integer waitressId;
    private Integer chefId;
}
