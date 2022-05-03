package com.example.online_exam_system_backend.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * <p>
 * 选择题表
 * </p>
 *
 * @author Kayan
 * @since 2022-05-03
 */
@ApiModel(value = "MultipleChoiceQuestion对象", description = "选择题表")
public class MultipleChoiceQuestion implements Serializable {

    private static final long serialVersionUID = 1L;

      @ApiModelProperty("题目编号")
        @TableId(value = "id", type = IdType.AUTO)
      private Integer id;

      @ApiModelProperty("所属课程")
      private String course;

      @ApiModelProperty("选项A")
      private String optionA;

      @ApiModelProperty("选项B")
      private String optionB;

      @ApiModelProperty("选项C")
      private String optionC;

      @ApiModelProperty("选项D")
      private String optionD;

      @ApiModelProperty("答案")
      private String answer;

      @ApiModelProperty("解释")
      private String explanation;

    
    public Integer getId() {
        return id;
    }

      public void setId(Integer id) {
          this.id = id;
      }
    
    public String getCourse() {
        return course;
    }

      public void setCourse(String course) {
          this.course = course;
      }
    
    public String getOptionA() {
        return optionA;
    }

      public void setOptionA(String optionA) {
          this.optionA = optionA;
      }
    
    public String getOptionB() {
        return optionB;
    }

      public void setOptionB(String optionB) {
          this.optionB = optionB;
      }
    
    public String getOptionC() {
        return optionC;
    }

      public void setOptionC(String optionC) {
          this.optionC = optionC;
      }
    
    public String getOptionD() {
        return optionD;
    }

      public void setOptionD(String optionD) {
          this.optionD = optionD;
      }
    
    public String getAnswer() {
        return answer;
    }

      public void setAnswer(String answer) {
          this.answer = answer;
      }
    
    public String getExplanation() {
        return explanation;
    }

      public void setExplanation(String explanation) {
          this.explanation = explanation;
      }

    @Override
    public String toString() {
        return "MultipleChoiceQuestion{" +
              "id=" + id +
                  ", course=" + course +
                  ", optionA=" + optionA +
                  ", optionB=" + optionB +
                  ", optionC=" + optionC +
                  ", optionD=" + optionD +
                  ", answer=" + answer +
                  ", explanation=" + explanation +
              "}";
    }
}
