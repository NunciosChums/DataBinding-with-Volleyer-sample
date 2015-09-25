package kr.susemi99.databindingsample.items;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.text.SimpleDateFormat;
import java.util.Date;

@JsonIgnoreProperties(ignoreUnknown = true)
public class RowItem
{
  @JsonProperty("CLASS_CODE")
  public String classCode;

  @JsonProperty("CLASS_NAME")
  public String className;

  @JsonProperty("ORGAN_CODE")
  public String organCode;

  @JsonProperty("ORGAN_NAME")
  public String organName;

  @JsonProperty("DIFFICULTY")
  public String difficulty;

  @JsonProperty("DIFFICULTY_NAME")
  public String difficultyName;

  @JsonProperty("RECEIVE_FROM")
  public String receiveFrom;

  @JsonProperty("RECEIVE_TO")
  public String receiveTo;

  @JsonProperty("RECEIVE_TIME_FROM")
  public String receiveTimeFrom;

  @JsonProperty("RECEIVE_TIME_TO")
  public String receiveTimeTo;

  @JsonProperty("EDUCATE_FROM")
  public String educateFrom;

  @JsonProperty("EDUCATE_TO")
  public String educateTo;

  @JsonProperty("EDUCATE_TIME_FROM")
  public String educateTimeFrom;

  @JsonProperty("EDUCATE_TIME_TO")
  public String educateTimeTo;

  @JsonProperty("MONDAY")
  public String monday;

  @JsonProperty("TUESDAY")
  public String tuesday;

  @JsonProperty("WEDNESDAY")
  public String wednesday;

  @JsonProperty("THURSDAY")
  public String thursday;

  @JsonProperty("FRIDAY")
  public String friday;

  @JsonProperty("SATURDAY")
  public String saturday;

  @JsonProperty("SUNDAY")
  public String sunday;

  @JsonProperty("COLLECT_NUM")
  public String collectNum;

  @JsonProperty("SPARE_NUM")
  public String spareNum;

  @JsonProperty("EDUCATE_FEE")
  public String educateFee;

  @JsonProperty("VISIT_RECEIVE_FLAG")
  public String visitReceiveFlag;

  @JsonProperty("ONLINE_RECEIVE_FLAG")
  public String onlineReceiveFlag;

  @JsonProperty("URL")
  public String url;

  public String displayReceiveFrom()
  {
    return parseDate(receiveFrom, "yyyyMMdd");
  }

  public String displayReceiveTo()
  {
    return parseDate(receiveTo, "yyyyMMdd");
  }

  private String parseDate(String dateStr, String pattern)
  {
    String result = dateStr;

    try
    {
      SimpleDateFormat formatter = new SimpleDateFormat(pattern);
      Date date = formatter.parse(dateStr);
      result = format(date.getTime(), "yyyy.MM.dd");
    } catch (Exception e)
    {
      e.printStackTrace();
    }

    return result;
  }

  private String format(long timeInMills, String pattern)
  {
    SimpleDateFormat formatter = new SimpleDateFormat(pattern);
    return formatter.format(timeInMills);
  }
}