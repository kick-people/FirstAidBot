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
@AllArgsConstructor
@NoArgsConstructor
public class AnswerSearchByQueryDto {

  private String batchcomplete;
  private String warning;
  private PagesDTO query;

}
