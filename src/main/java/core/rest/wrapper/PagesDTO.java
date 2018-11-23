package core.rest.wrapper;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by Vitalii_Strieltsov on 11/20/2018
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PagesDTO {

  private Integer pageid;
  private Integer ns;
  private String title;
  private String extract;
}
