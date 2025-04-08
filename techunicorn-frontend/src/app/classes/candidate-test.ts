import { Candidate } from "./candidate";
import { Test } from "./test";

export class CandidateTest {
    candidate: Candidate;
    test: Test;

    constructor(candidate: Candidate, test: Test){
        this.candidate = candidate;
        this.test = test;
    }
}
