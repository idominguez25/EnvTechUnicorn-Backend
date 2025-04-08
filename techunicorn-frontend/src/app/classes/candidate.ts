import { Assessment } from './assessment';

export class Candidate {
    id: number;
    email: String;
    firstName: String;
    lastName: String;
    assessments: Assessment[];
    
    constructor(id: number, email: String, firstName: String, lastName: String, assessments: Assessment[]) {
        this.id = id;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.assessments = assessments;
    }
}
