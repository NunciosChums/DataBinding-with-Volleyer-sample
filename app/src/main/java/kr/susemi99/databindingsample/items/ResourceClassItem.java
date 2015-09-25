package kr.susemi99.databindingsample.items;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ResourceClassItem
{
  @JsonProperty("list_total_count")
  public int totalCount;

  @JsonProperty("RESULT")
  public ResultItem result;

  @JsonProperty("row")
  public ArrayList<RowItem> rows;
}
