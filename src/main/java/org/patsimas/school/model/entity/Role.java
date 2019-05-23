package org.patsimas.school.model.entity;

public class Role {
	   
    public static final Role DIRECTOR  = new Role(1l, "Director");
    public static final Role PROFESSOR = new Role(2l, "Professor");
    public static final Role PUPIL = new Role(3l, "Pupil");
    
    private final Long rid;
    private final String name;
    

    private Role(Long rid, String name) {
        this.rid = rid;
        this.name = name;
    }

    public Long getRid() {
        return rid;
    }

    

    public String getName() {
        return name;
    }

    

    @Override
    public String toString() {
        return "Role{" + "rid=" + rid + ", name=" + name + '}';
    }
    
    public static final Role getRoleFor(Long rid) throws Exception {
        if (rid == DIRECTOR.getRid()) {
            return DIRECTOR;
        }
        else if (rid == PROFESSOR.getRid()) {
            return PROFESSOR;
        }
        else if (rid == PUPIL.getRid()) {
            return PUPIL;
        }
        else {
            throw new Exception("Invalid role id: " + rid);
        }
    }
    
}
