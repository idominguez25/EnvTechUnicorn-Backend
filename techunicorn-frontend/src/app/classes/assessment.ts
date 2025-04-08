export class Assessment {

    id: number;
    status: String;
    startDate: Date;
    finishDate: String;
    timeTakenInSeconds: number;
    timeLimitInSeconds: number;
    scoredPoints: number;
    maxPoints: number;
    percentage: number;
    
    constructor(id: number, status: String, startDate: Date, finishDate: String, timeTakenInSeconds: number, timeLimitInSeconds: number, scoredPoints: number, maxPoints: number, percentage: number) {
        this.id = id;
        this.status = status;
        this.startDate = startDate;
        this.finishDate = finishDate;
        this.timeTakenInSeconds = timeTakenInSeconds;
        this.timeLimitInSeconds = timeLimitInSeconds;
        this.scoredPoints = scoredPoints;
        this.maxPoints = maxPoints;
        this.percentage = percentage;
    }

}
