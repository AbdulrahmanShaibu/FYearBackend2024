//package Project.Spring.Boot.Project.University.Models;
//
//import jakarta.persistence.*;
//import jakarta.validation.constraints.NotNull;
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//@AllArgsConstructor
//@NoArgsConstructor
//@Data
//@Entity
//@Table
//public class UniversityCleaner {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    public int CleanerID;
//
//    public String CleanerName;
//    public String Gender;
//
//    //many cleaners to one department
//    @ManyToOne
//    @NotNull
//    private ClientSite clientSite;
//
//    //many cleaners to a tool
//    @ManyToOne
//    @NotNull
//    private Tool tool;
//
//}
