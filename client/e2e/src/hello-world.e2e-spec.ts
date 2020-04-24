import {Ng2ProjectPage} from './hello-world.po';

describe('ng2-project Hello World', function () {
  let page: Ng2ProjectPage;

  beforeEach(() => {
    page = new Ng2ProjectPage();
  });

  it('should have the correct message', () => {
    page.navigateTo();
    expect(page.getParagraph()).toEqual('Hello World');
  });
});
