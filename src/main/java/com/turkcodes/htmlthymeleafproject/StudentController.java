package com.turkcodes.htmlthymeleafproject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
/**
 * Created by David Turk on 8/1/17.
 */

@Controller
public class StudentController {

    @RequestMapping("/")
    public String home(){
        return "index";
    }

    @RequestMapping("/new_student")
    public String newStudent(Model model) {
        model.addAttribute("grades", Grade.values() );
        return "new_student";
    }

    @RequestMapping(value = "/create_student", method = RequestMethod.POST)
    public String createStudent(@RequestParam(value="first_name") String firstName,
                                @RequestParam(value="last_name") String lastName,
                                @RequestParam(value="grade") String grade,
                                Model model) {
        Student student = new Student();

        /* set student firstName, lastName and grade using the http request parameters */
        student.setFirstName(firstName);
        student.setLastName(lastName);
        student.setGrade(processGrade(grade));

        /* add the student to the model that will be used by the view_student html file */
        model.addAttribute("student",student);

        return "view_student";
    }

    private Grade processGrade(String grade) {
        switch(grade.toLowerCase()){
            case "first":
                return Grade.First;
            case "second":
                return Grade.Second;
            case "third":
                return Grade.Third;
            case "fourth":
                return Grade.Fourth;
            case "fifth":
                return Grade.Fifth;
            case "sixth":
                return Grade.Sixth;
            case "seventh":
                return Grade.Seventh;
            case "eighth":
                return Grade.Eighth;
            case "ninth":
                return Grade.Ninth;
            case "tenth":
                return Grade.Tenth;
            case "eleventh":
                return Grade.Eleventh;
            case "twelfth":
                return Grade.Twelfth;
            default:
                return null; //Should never be reached
        }
    }
}
