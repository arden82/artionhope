$(document).ready(function () {
  // 获取所有增加按钮
  var increaseButtons = $('.increase');
  // 获取所有减少按钮
  var decreaseButtons = $('.decrease');
  // 获取所有数量输入框
  var quantityInputs = $('.quantity-amount');
  // 获取所有价格元素
  var priceElements = $('.price');
  // 获取所有小计元素
  var totalPriceElements = $('.total_price');
  var discountInput = $('#coupon').val();
  var discountButton = $('.btn_discount');

  // 绑定增加按钮的点击事件
  increaseButtons.off('click').on('click', function () {
    var index = increaseButtons.index(this);
    updatePriceAndTotal(index);
  });

  // 绑定减少按钮的点击事件
  decreaseButtons.off('click').on('click', function () {
    var index = decreaseButtons.index(this);
    updatePriceAndTotal(index);
  });

  // 点击使用折扣码按钮
  discountButton.off('click').on('click', function () {
    
    var discountInput = $('#coupon').val();
    $('.price_discount.text-black').text(discountInput);
    updateDiscount();
   
    

  });

  function updatePriceAndTotal(index) {
    var quantityInput = quantityInputs.eq(index);
    var currentVal = parseInt(quantityInput.val());
    var itemPrice = parseFloat(priceElements.eq(index).text().replace('$', ''));
    var newSubtotal = currentVal * itemPrice;
    totalPriceElements.eq(index).text('$' + newSubtotal);
    updateTotal();
  }

  function updateTotal() {
    var totalPrices = $('.total_price');
    var subtotal = 0;
    totalPrices.each(function () {
      subtotal += parseFloat($(this).text().replace('$', ''));
    });

    var subtotalElement = $('.price_smallcount');
    subtotalElement.text('$' + subtotal);

    updateDiscount();
  }

  function updateDiscount() {
    var discountAmount = parseFloat($('.price_discount').text().replace('$', ''));
    
    console.log("折價金額:" + discountAmount);
    var subtotal = parseFloat($('.price_smallcount').text().replace('$', ''));
    console.log("小計金額:"+ subtotal);
    var total = subtotal - discountAmount;

    var totalElement = $('.price_all');
    totalElement.text('$' + total);
  }

  // function getDiscountAmount(couponCode) {
    // 在实际应用中，你可以根据折扣码查询数据库或定义折扣规则
    // 这里简单演示直接返回一个假的折扣金额
    // return 50; // 这里返回50作为折扣金额，你可以根据实际需求修改
  // }
    
 });

/**
 * 
 */