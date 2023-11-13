package br.com.educatech.models;

public class Course {
    private Long id;


    private String name;
    private String description;
    private String teacher;

    private Integer duration;
    private Category category;

    public Course(String name, Category category, String description, String teacher, Integer duration) {
        this.name = name;
        this.category = category;
        this.description = description;
        this.teacher = teacher;
        this.duration = duration;
    }

    public Course(Long id, String name, String description, String teacher, Integer duration, Category category) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.teacher = teacher;
        this.duration = duration;
        this.category = category;
    }

    public Course(String name, String description, String teacher, Integer duration) {
        this.name = name;
        this.description = description;
        this.teacher = teacher;
        this.duration = duration;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
