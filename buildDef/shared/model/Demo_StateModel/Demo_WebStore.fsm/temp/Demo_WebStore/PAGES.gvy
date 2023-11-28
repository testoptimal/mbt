// PAGE Script
import org.openqa.selenium.By;

ProductList = $SYS.getPageMgr().addPage('ProductList');
ProductList.addAction ('getTitle', { page, params ->
    $SELENIUM.getWebDriver().getTitle();
})
elem = ProductList.addElement('DetailItems', By.cssSelector('.desc'))
elem.addAction('countItems', { elem, params ->
    $SELENIUM.getWebDriver().findElements(elem.locator).size();
})
elem = ProductList.addElement('ShoppingCart', By.id('shoppingcart'))
elem.addAction('click', { elem, params ->
    $SELENIUM.getWebDriver().findElement(elem.locator).click();
})
elem.addAction('isPresent', { elem, params ->
    $SELENIUM.getWebDriver().findElements(elem.locator).size()>0
})
elem = ProductList.addElement('AddItemByProdCode', null)
elem.addAction('click', { elem, params ->
    $SELENIUM.getWebDriver().findElement(By.cssSelector('#' + params[0] + ' .addLink')).click();
})
elem = ProductList.addElement('DetailItemByProdCode', null)
elem.addAction('click', { elem, params ->
    $SELENIUM.getWebDriver().findElement(By.cssSelector('#' + params[0] + ' .desc')).click();
})

ItemsDetails = $SYS.getPageMgr().addPage('ItemDetails');
ItemsDetails.addAction ('getTitle', { page, params ->
    $SELENIUM.getWebDriver().getTitle();
})
ItemsDetails.addAction ('getBodyText', { elem, params ->
    $SELENIUM.getWebDriver().findElement(By.tagName('body')).getText();
})
elem = ItemsDetails.addElement('ProdList', By.id('prodList'))
elem.addAction('click', { elem, params ->
    $SELENIUM.getWebDriver().findElement(elem.locator).click();
})
elem = ItemsDetails.addElement('ShoppingCart', By.id('shoppingcart'))
elem.addAction('click', { elem, params ->
    $SELENIUM.getWebDriver().findElement(elem.locator).click();
})
elem = ItemsDetails.addElement('AddItem', null)
elem.addAction('click', { elem, params ->
    $SELENIUM.getWebDriver().findElement(By.cssSelector('#' + params[0] + ' .addLink')).click();
})

ShoppingCart = $SYS.getPageMgr().addPage('ShoppingCart');
ShoppingCart.addAction ('getTitle', { page, params ->
    $SELENIUM.getWebDriver().getTitle();
})
ShoppingCart.addAction ('getBodyText', { elen, params ->
    $SELENIUM.getWebDriver().findElement(By.tagName('body')).getText();
})
elem = ShoppingCart.addElement('OrderItems', By.className('item'))
elem.addAction('getProdCodes', { elem, params ->
    retList = [];
    items = $SELENIUM.getWebDriver().findElements(elem.locator);
    for (item in items) {
        retList.add(item.getAttribute('id'));
    }
    retList;
})
elem.addAction('getProdCode', { elem, params ->
    $SELENIUM.getWebDriver().findElements(elem.locator).get(0).getAttribute('id');
})
elem.addAction('countItems', { elem, params ->
    $SELENIUM.getWebDriver().findElements(elem.locator).size();
})
elem = ShoppingCart.addElement('ProdList', By.id('prodList'))
elem.addAction('click', { elem, params ->
    $SELENIUM.getWebDriver().findElement(elem.locator).click();
})
elem = ShoppingCart.addElement('TotalCost', By.className('totalPrice'))
elem.addAction('getText', { elem, params ->
    $SELENIUM.getWebDriver().findElement(elem.locator).getText();
})
elem = ShoppingCart.addElement('OrderBtn', By.id('checkOutBtn'))
elem.addAction('click', { elem, params ->
    $SELENIUM.getWebDriver().findElement(elem.locator).click();
})
elem.addAction('isDisplayed', { elem, params ->
    $SELENIUM.getWebDriver().findElement(By.id('checkOutBtn')).isDisplayed();
})
elem = ShoppingCart.addElement('RemoveLinks', By.cssSelector('.removeLink'))
elem.addAction('clickOne', { elem, params ->
    webdriver = $SELENIUM.getWebDriver();
    items = webdriver.findElements(elem.locator);
    randIdx = $RAND.randNum(0, items.size()-1);
    items.get(randIdx).click();
    randIdx;
})
elem.addAction('countItems', { elem, params ->
    $SELENIUM.getWebDriver().findElements(elem.locator).size();
})

CheckOut = $SYS.getPageMgr().addPage('Checkout');
CheckOut.addAction ('getTitle', { page, params ->
    $SELENIUM.getWebDriver().getTitle();
})
elem = CheckOut.addElement('ContinueShopping', By.id('prodList'))
elem.addAction('click', { elem, params ->
    $SELENIUM.getWebDriver().findElement(elem.locator).click();
})
elem = CheckOut.addElement('PaymentType', null)
elem.addAction('click', { elem, params ->
    $SELENIUM.getWebDriver().findElement(By.id(params[0])).click();
})
elem = CheckOut.addElement('CreditCardNum', By.id('CreditCardNum'))
elem.addAction('type', { elem, params ->
    $SELENIUM.getWebDriver().findElement(elem.locator).sendKeys(params[0]);
})
elem = CheckOut.addElement('ShippingMethod', By.id('shippingMethod'))
elem.addAction('select', { elem, params ->
    $SELENIUM.assist().selectOptionByText(elem.locator, params[0]);
})
elem = CheckOut.addElement('ReceiveEmail', By.id('receiveEmail'))
elem.addAction('set', { elem, params ->
    $SELENIUM.assist().setCheckbox(elem.locator, params[0]);
})
elem = CheckOut.addElement('ReceiveNewsLetter', By.id('receiveNews'))
elem.addAction('set', { elem, params ->
    $SELENIUM.assist().setCheckbox(elem.locator, params[0]);
})
elem = CheckOut.addElement('PlaceOrder', By.id('placeOrder'))
elem.addAction('click', { elem, params ->
    $SELENIUM.getWebDriver().findElement(elem.locator).click();
})
elem = CheckOut.addElement('ShoppingCart', By.id('shoppingcart'))
elem.addAction('click', { elem, params ->
    $SELENIUM.getWebDriver().findElement(elem.locator).click();
})

ThankYou = $SYS.getPageMgr().addPage('ThankYou');
ThankYou.addAction ('getTitle', { page, params ->
    $SELENIUM.getWebDriver().getTitle();
})
ThankYou.addAction ('getBodyText', {elem, params ->
    $SELENIUM.getWebDriver().findElement(By.tagName('body')).getText();
})
elem = ThankYou.addElement('ContinueShopping', By.id('prodList'))
elem.addAction('click', { elem, params ->
    $SELENIUM.getWebDriver().findElement(elem.locator).click();
})
elem = ThankYou.addElement('ShoppingCart', By.id('shoppingcart'))
elem.addAction('click', { elem, params ->
    $SELENIUM.getWebDriver().findElement(elem.locator).click();
})
