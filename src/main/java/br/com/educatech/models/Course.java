package br.com.educatech.models;

public class Course {
 private Long id;
 private String name;
 private String teacher;
 private Category category;

 public Long getId() {
  return id;
 }

 public String getName() {
  return name;
 }

 public void setName(String name) {
  this.name = name;
 }

 public String getTeacher() {
  return teacher;
 }

 public void setTeacher(String teacher) {
  this.teacher = teacher;
 }
}
