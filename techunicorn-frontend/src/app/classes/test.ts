import { Skill } from "./skill";

export class Test {
    name: String;
    skills: Skill[];
    
    constructor(name: String, skills: Skill[]) {
        this.name = name;
        this.skills = skills;
    }
}
