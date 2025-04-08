import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'status'
})
export class StatusPipe implements PipeTransform {

  transform(value: string, ...args: string[]): string {
    var description: string = "";
    switch(value) {
      case "NEW":
        description = "New";
        break;
      case "TOKEN_SENT":
        description = "Pending";
        break;
      case "TOKEN_EXPIRED":
        description = "Expired";
        break;
      case "TEST_STARTED":
        description = "Pending";
        break;
      case "TEST_FINISHED":
        description = "Pending";
        break;
      case "AUTO_ASSESSMENT_READY":
        description = "Pending";
        break;
      case "ERROR":
        description = "Cancelled";
        break;
      case "CANCELED":
        description = "Cancelled";
        break;
    }
    return description;
  }

}
