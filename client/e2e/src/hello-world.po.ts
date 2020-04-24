import { browser, element, by } from 'protractor';

export class Ng2ProjectPage {
  navigateTo() {
    return browser.get('/#/hello-world');
  }

  getTitle() {
    return browser.getTitle();
  }

  getParagraph() {
    return element(by.tagName('p')).getText();
  }
}
