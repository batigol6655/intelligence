<%@page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<%@taglib uri="/struts-tags" prefix="s" %>
<html>
<!-- Added by HTTrack --><meta http-equiv="content-type" content="text/html;charset=utf-8" /><!-- /Added by HTTrack -->
<head>
    <meta charset="utf-8">
    
    <title>Product view</title>
    <meta name="description" content="">
    <meta name="viewport" content="width=device-width">
    
    <link rel="shortcut icon" href="favicon.ico">

    <link rel="stylesheet" href="css/grid.css">
    <link rel="stylesheet" href="css/style.css">
    <link rel="stylesheet" href="css/normalize.css">

    <script src="js/jquery.min.js"></script>
    <script>window.jQuery || document.write('<script src="js/jquery-1.8.3.min.js"><\/script>')</script>
    <script src="js/html5.js"></script>
    <script src="js/main.js"></script>
    <script src="js/radio.js"></script>
    <script src="js/checkbox.js"></script>
    <script src="js/selectBox.js"></script>
    <script src="js/jquery.carouFredSel-5.2.2-packed.js"></script>
    <script src="js/jquery.jqzoom-core.js"></script>
    <script src="js/jquery.transit.js"></script>
    <script src="js/jquery.easing.1.2.js"></script>
    <script src="js/jquery.anythingslider.js"></script>
    <script src="js/jquery.anythingslider.fx.js"></script>
</head>
<s:debug></s:debug>
<body>
    <div id="top">
        <div class="container_12">
            <div class="grid_3">
                <div class="lang">
                    <ul>
                        <li class="current"><a href="#">EN</a></li>
                        <li><a href="#">FR</a></li>
                        <li><a href="#">GM</a></li>
                    </ul>
                </div><!-- .lang -->
                
                <div class="currency">
                    <ul>
                        <li class="current"><a href="#">$</a></li>
                        <li><a href="#">&#8364;</a></li>
                        <li><a href="#">&#163;</a></li>
                    </ul>
                </div><!-- .currency -->
            </div><!-- .grid_3 -->
            
            <div class="grid_9">
                <nav>
                    <ul>
                        <li class="current"><a href="#">My Account</a></li>
                        <li><a href="#">My Wishlist</a></li>
                        <li><a href="login.html">Log In</a></li>
                        <li><a href="login.html">Sign Up</a></li>
                    </ul>
                </nav>
            </div><!-- .grid_9 -->
        </div>
    </div><!-- #top -->
    
    <header>
        <div class="container_12">
            <div class="grid_3">
                <hgroup>
                    <h1 id="site_logo" ><a href="index.html" title=""><img src="img/logo.png" alt="Online Store Theme Logo"></a></h1>
                    <h2 id="site_description">Online Store Theme</h2>
                </hgroup>
            </div><!-- .grid_3 -->
            
            <div class="grid_9">
                <div class="top_header">
                    <div class="welcome">
                        Welcome visitor you can <a href="login.html">login</a> or <a href="login.html">create an account</a>.
                    </div><!-- .welcome -->
                
                    <ul id="cart_nav">
                        <li>
                            <a class="cart_li" href="#">
                                <div class="cart_ico"></div>
                                Cart
                                <span>$0.00</span>
                            </a>
                            <ul class="cart_cont">
                                <li class="no_border recently">Recently added item(s)</li>
                                <li>
                                    <a href="product_page.html" class="prev_cart"><div class="cart_vert"><img src="img/content/cart_img.png" alt="Product 1" title=""></div></a>
                                    <div class="cont_cart">
                                        <h4>Faddywax Fragrance Diffuser Set <br>Gardenia</h4>
                                        <div class="price">1 x <span>$399.00</span></div>
                                    </div>
                                    <a title="close" class="close" href="#"></a>
                                    <div class="clear"></div>
                                </li>
              
                                <li>
                                    <a href="product_page.html" class="prev_cart"><div class="cart_vert"><img src="img/content/cart_img2.png" alt="Product 2" title=""></div></a>
                                    <div class="cont_cart">
                                        <h4>Caldrea Linen and Room Spray</h4>
                                        <div class="price">1 x <span>$123.00</span></div>
                                    </div>
                                    <a title="close" class="close" href="#"></a>
                                    <div class="clear"></div>
                                </li>
                                <li class="no_border">
                                    <a href="shopping_cart.html" class="view_cart">View shopping cart</a>
                                    <a href="checkout.html" class="checkout">Procced to Checkout</a>
                                </li>
                            </ul>
                        </li>
                    </ul><!-- .cart_nav -->
                    
                    <form class="search">
                        <input type="submit" class="search_button" value="">
                        <input type="text" name="search" class="search_form" value="" placeholder="Search entire store here...">
                    </form><!-- .search -->
                </div><!-- .top_header -->
                
                <nav class="primary">
                    <ul>
                        <li class="curent"><a href="index.html">Home</a></li>
                        <li><a href="catalog_grid.html">Solids</a></li>
                        <li><a href="catalog_grid.html">Liquids</a></li>
                        <li class="parent">
                            <a href="catalog_grid.html">Spray</a>
                            <ul class="sub">
                                <li><a href="catalog_grid.html">For home</a></li>
                                <li><a href="catalog_grid.html">For Garden</a></li>
                                <li><a href="catalog_grid.html">For Car</a></li>
                                <li><a href="catalog_grid.html">Other spray</a></li>
                            </ul>
                        </li>
                        <li><a href="catalog_grid.html">Electric</a></li>
                        <li><a href="catalog_grid.html">For cars</a></li>
                        <li class="parent">
                            <a href="#">All pages</a>
                            <ul class="sub">
                                <li><a href="index.html">Home</a></li>
                                <li><a href="typography_page.html">Typography and basic styles</a></li>
                                <li><a href="catalog_grid.html">Catalog (grid view)</a></li>
                                <li><a href="catalog_list.html">Catalog (list type view)</a></li>
                                <li><a href="product_page.html">Product view</a></li>
                                <li><a href="shopping_cart.html">Shoping cart</a></li>
                                <li><a href="checkout.html">Proceed to checkout</a></li>
                                <li><a href="compare.html">Products comparison</a></li>
                                <li><a href="login.html">Login</a></li>
                                <li><a href="contact_us.html">Contact us</a></li>
                                <li><a href="404.html">404</a></li>
                                <li><a href="blog.html">Blog posts</a></li>
                                <li><a href="blog_post.html">Blog post view</a></li>
                            </ul>
                        </li>
                    </ul>
                </nav><!-- .primary -->
            </div><!-- .grid_9 -->
        </div>
    </header>
    
    <div class="breadcrumbs">
        <div class="container_12">
            <div class="grid_12">
                 <a href="index.html">Home</a><span></span><a href="#">Category</a><span></span><span class="current">This page</span>
            </div><!-- .grid_12 -->
        </div><!-- .container_12 -->
    </div><!-- .breadcrumbs -->
    
    <section id="main">
        <div class="container_12">
            <div id="content" class="grid_12">
                <header>
                    <h1 class="page_title"><s:property value="#session.it.title"/></h1>
                </header>
                    
                <article class="product_page">
                    <div class="grid_5 img_slid" id="products">
			<img class="sale" src="img/sale.png" alt="Sale">
			<div class="preview slides_container">
			    <div class="prev_bg">
				<a href="<s:property value='#session.it.picture_link'/>" class="jqzoom" rel='gal1' title="">
				    <img src="<s:property value='#session.it.picture_link'/>" alt="Product 1" title="">
				</a>
			    </div>
			</div><!-- .preview -->
                        
                        <div class="next_prev">
			    <a id="img_prev" class="arows" href="#"><span>Prev</span></a>
			    <a id="img_next" class="arows" href="#"><span>Next</span></a>
			</div><!-- .next_prev -->

			<ul class="small_img clearfix" id="thumblist">
			    <li><a class="zoomThumbActive" href='javascript:void(0);' rel="{gallery: 'gal1', smallimage: '<s:property value='#session.it.picture_link'/>',largeimage: '<s:property value='#session.it.picture_link'/>'}"><img src="<s:property value='#session.it.picture_link'/>" alt=""></a></li>
			    <s:iterator value="#session.picture">
			    	<li><a class="zoomThumbActive" href='javascript:void(0);' rel="{gallery: 'gal1', smallimage: '<s:property value='picture_name'/>',largeimage: '<s:property value='picture_name'/>'}"><img src="<s:property value='picture_name'/>" alt=""></a></li>
			    
			    </s:iterator>
			    </ul><!-- .small_img -->

			<div id="pagination"></div>
		    </div><!-- .grid_5 -->
                    
                    <div class="grid_7">
			<div class="entry_content">
                            <div class="soc">
				<img src="img/soc.png" alt="Soc">
			    </div><!-- .soc -->
                            
			    <div class="review">
				<a class="plus" href="#"></a>
				<a class="plus" href="#"></a>
				<a class="plus" href="#"></a>
				<a href="#"></a>
				<a href="#"></a>
				<span><strong>3</strong> REVIEW(S)</span>
                                <span class="separator">|</span>
			        <a class="add_review" href="#">ADD YOUR REVIEW</a>
			    </div>
                            
			    <p><s:property value="#session.itContent.describe"/></p>
                            
                            <div class="ava_price">
                                <div class="price">
                                    <div class="price_old">￥<s:property value="#session.it.price_new"/></div>
                                   		 ￥<s:property value="#session.it.price_old"/>
				</div><!-- .price -->
                                
				<div class="availability_sku">
				    <div class="availability">
					Availability: <span>In stock</span>
				    </div>
				    <div class="sku">
					SKU: <span>Candles OV</span>
				    </div>
				</div><!-- .availability_sku -->
                                <div class="clear"></div>
			    </div><!-- .ava_price -->
                            
                            <div class="parameter_selection">
                                <select>
                                    <option>Select a size</option>
                                    <option>Select a size</option>
                                </select>
                                <select>
                                    <option>Choose a material</option>
                                    <option>Choose a material</option>
                                </select>
			    </div><!-- .parameter_selection -->

			    <div class="cart">
                                <a href="#" class="bay"><img src="img/bg_cart.png" alt="Buy" title="">Add to Cart</a>
                                <a href="#" class="like"><img src="img/like.png" alt="" title=""> Add to Compare</a>
                                <a href="#" class="obn"><img src="img/obl.png" alt="" title="">Add to Compare</a>
                            </div><!-- .cart -->

			</div><!-- .entry_content -->
		    </div><!-- .grid_7 -->
		    <div class="clear"></div>
                    
                    <div class="grid_12" >
			<div id="wrapper_tab" class="tab1">
			    <a href="#" class="tab1 tab_link">Description</a>
			    <a href="#" class="tab2 tab_link">Reviews</a>
			    <a href="#" class="tab3 tab_link">Custom Tab</a>

			    <div class="clear"></div>

			    <div class="tab1 tab_body">
					<s:property value="#session.itContent.content"/>
                <div class="clear"></div>
			    </div><!-- .tab1 .tab_body -->

			    <div class="tab2 tab_body">
				<h4>Customer reviews</h4>
                                
                                <ul class="comments">
				    <li>
					<div class="autor">Mike Example</div>, <time datetime="2012-11-03">03.11.2012</time>

					<div class="evaluation">
					    <div class="quality">
						<span>Quality</span>
						<a class="plus" href="#"></a>
						<a class="plus" href="#"></a>
						<a class="plus" href="#"></a>
						<a href="#"></a>
						<a href="#"></a>
					    </div>
					    <div class="price">
                                                <span>Price</span>
                                                <a class="plus" href="#"></a>
						<a class="plus" href="#"></a>
						<a class="plus" href="#"></a>
						<a class="plus_minus" href="#"></a>
						<a href="#"></a>
					    </div>
					    <div class="clear"></div>
					</div><!-- .evaluation -->

					<p>Suspendisse at placerat turpis. Duis luctus erat vel magna pharetra aliquet. Maecenas tincidunt feugiat ultricies. Phasellus et dui risus. Vestibulum adipiscing, eros quis lobortis dictum.  It enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.</p>
                                    </li>

				    <li>
					<div class="autor">Mike Example</div>, <time datetime="2012-11-03">01.11.2012</time>

					<div class="evaluation">
					    <div class="quality">
						<span>Quality</span>
						<a class="plus" href="#"></a>
						<a class="plus" href="#"></a>
						<a class="plus" href="#"></a>
						<a class="plus" href="#"></a>
						<a class="plus_minus" href="#"></a>
					    </div>
					    <div class="price">
						<span>Price</span>
						<a class="plus" href="#"></a>
						<a class="plus" href="#"></a>
						<a class="plus" href="#"></a>
						<a class="plus" href="#"></a>
						<a href="#"></a>
					    </div>
					    <div class="clear"></div>
					</div><!-- .evaluation -->

					<p>Etiam mollis volutpat odio, id euismod justo gravida a. Aliquam erat volutpat. Phasellus faucibus venenatis lorem, vitae commodo elit pretium et. Duis rhoncus lobortis congue. Vestibulum et purus dui, vel porta lectus. Sed vulputate pulvinar adipiscing. It enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.</p>
                                    </li>
				</ul><!-- .comments -->
                                
                                <form class="add_comments">
				    <h4>Write Your Own Review</h4>

					<div class="evaluation">
					    <div class="quality">
						Quality<sup>*</sup>
						<input class="niceRadio" type="radio" name="quality" value="1"><span class="eva_num">1</span>
						<input class="niceRadio" type="radio" name="quality" value="2"><span class="eva_num">2</span>
						<input class="niceRadio" type="radio" name="quality" value="3"><span class="eva_num">3</span>
						<input class="niceRadio" type="radio" name="quality" value="4"><span class="eva_num">4</span>
						<input class="niceRadio" type="radio" name="quality" value="5"><span class="eva_num">5</span>
					    </div>
					    <div class="price">
						Price<sup>*</sup>
						<input class="niceRadio" type="radio" name="price" value="1"><span class="eva_num">1</span>
						<input class="niceRadio" type="radio" name="price" value="2"><span class="eva_num">2</span>
						<input class="niceRadio" type="radio" name="price" value="3"><span class="eva_num">3</span>
						<input class="niceRadio" type="radio" name="price" value="4"><span class="eva_num">4</span>
						<input class="niceRadio" type="radio" name="price" value="5"><span class="eva_num">5</span>
					    </div>
					    <div class="clear"></div>
					</div><!-- .evaluation -->

					<div class="text_review">
					    <strong>Review</strong><sup>*</sup><br>
					    <textarea name="text"></textarea><br>
					    <i>Note: HTML is not translated!</i>
					</div><!-- .text_review -->
                                        
                                        <div class="nickname">
					    <strong>Nickname</strong><sup>*</sup><br>
					    <input type="text" name="" class="" value="">
					</div><!-- .nickname -->

					<div class="your_review">
					    <strong>Summary of Your Review</strong><sup>*</sup><br>
					    <input type="text" name="" class="" value="">
					</div><!-- .your_review -->

					<div class="clear"></div>

					

					<input type="submit" value="Submit Review">
				    </form><!-- .add_comments -->
                                <div class="clear"></div>
			    </div><!-- .tab2 .tab_body -->

			    <div class="tab3 tab_body">
				<h4>Custom Tab</h4>
				<div class="clear"></div>
			    </div><!-- .tab3 .tab_body -->
			    <div class="clear"></div>
			</div><!-- #wrapper_tab -->
			<div class="clear"></div>
		    </div><!-- .grid_12 -->
                    
		</article><!-- .product_page -->
                
                <div class="related grid_12">
                    
                        <div class="c_header">
                            <div class="grid_10">
                                <h2>Related Products</h2>
                            </div><!-- .grid_10 -->

                            <div class="grid_2">
                                <a id="next_c1" class="next arows" href="#"><span>Next</span></a>
                                <a id="prev_c1" class="prev arows" href="#"><span>Prev</span></a>
                            </div><!-- .grid_2 -->
                        </div><!-- .c_header -->

                        <div class="related_list">
                            <ul id="listing" class="products">
                                <li>
                                    <article class="grid_3 article">
                                        <img class="sale" src="img/sale.png" alt="Sale">
                                        <div class="prev">
                                            <a href="product_page.html"><img src="img/content/product1.png" alt="Product 1" title=""></a>
                                        </div><!-- .prev -->
                        
                                        <h3 class="title">handmade Emerald Cut<br> Emerald Ring</h3>
                                        <div class="cart">
                                            <div class="price">
                                                <div class="vert">
                                                    $550.00
                                                    <div class="price_old">$725.00</div>
                                                </div>
                                            </div>
                                            <a href="#" class="obn"></a>
                                            <a href="#" class="like"></a>
                                            <a href="#" class="bay"><img src="img/bg_cart.png" alt="Buy" title=""></a>
                                        </div><!-- .cart -->
                                    </article><!-- .grid_3.article -->
                                </li>
                                
                                <li>
                                    <article class="grid_3 article">
                                        <div class="prev">
                                             <a href="product_page.html"><img src="img/content/product2.png" alt="Product 2" title=""></a>
                                        </div><!-- .prev -->
                        
                                        <h3 class="title">beautiful Valentine And Engagement</h3>
                                        <div class="cart">
                                            <div class="price">
                                                <div class="vert">
                                                    $550.00
                                                    <div class="price_old">$725.00</div>
                                                </div>
                                            </div>
                                            <a href="#" class="obn"></a>
                                            <a href="#" class="like"></a>
                                            <a href="#" class="bay"><img src="img/bg_cart.png" alt="Buy" title=""></a>
                                        </div><!-- .cart -->
                                    </article><!-- .grid_3.article -->
                                </li>
                                
                                <li>
                                    <article class="grid_3 article">
                                        <img class="sale" src="img/new.png" alt="New">
                                        <div class="prev">
                                            <a href="product_page.html"><img src="img/content/product3.png" alt="Product 3" title=""></a>
                                        </div><!-- .prev -->
                        
                                        <h3 class="title">Emerald Cut Emerald Ring</h3>
                                        <div class="cart">
                                            <div class="price">
                                                <div class="vert">
                                                    $550.00
                                                    <div class="price_old">$725.00</div>
                                                </div>
                                            </div>
                                            <a href="#" class="obn"></a>
                                            <a href="#" class="like"></a>
                                            <a href="#" class="bay"><img src="img/bg_cart.png" alt="Buy" title=""></a>
                                        </div><!-- .cart -->
                                    </article><!-- .grid_3.article -->
                                </li>
                                
                                <li>
                                    <article class="grid_3 article">
                                        <div class="prev">
                                            <a href="product_page.html"><img src="img/content/product4.png" alt="Product 4" title=""></a>
                                        </div><!-- .prev -->
                        
                                        <h3 class="title">Diamond Necklaces and Pendants</h3>
                                        <div class="cart">
                                            <div class="price">
                                                <div class="vert">
                                                    $550.00
                                                    <div class="price_old">$725.00</div>
                                                </div>
                                            </div>
                                            <a href="#" class="obn"></a>
                                            <a href="#" class="like"></a>
                                            <a href="#" class="bay"><img src="img/bg_cart.png" alt="Buy" title=""></a>
                                        </div><!-- .cart -->
                                    </article><!-- .grid_3.article -->
                                </li>
                    
                                <li>
                                    <article class="grid_3 article">
                                        <div class="prev">
                                            <a href="product_page.html"><img src="img/content/product5.png" alt="Product 5" title=""></a>
                                        </div><!-- .prev -->
                        
                                        <h3 class="title">Emerald Diamond Solitaire</h3>
                                        <div class="cart">
                                            <div class="price">
                                                <div class="vert">
                                                    $550.00
                                                    <div class="price_old">$725.00</div>
                                                </div>
                                            </div>
                                            <a href="#" class="obn"></a>
                                            <a href="#" class="like"></a>
                                            <a href="#" class="bay"><img src="img/bg_cart.png" alt="Buy" title=""></a>
                                        </div><!-- .cart -->
                                    </article><!-- .grid_3.article -->
                                </li>
                            </ul><!-- #listing -->
                         </div><!-- .brands_list -->
                </div><!-- .related -->
                    
                <div class="clear"></div>
            </div><!-- #content -->

            <div class="clear"></div>
        </div><!-- .container_12 -->
    </section><!-- #main -->
    <div class="clear"></div>
        
    <footer>
        <div class="footer_navigation">
            <div class="container_12">
                <div class="grid_3">
                     <h3>Contact Us</h3>
                    <ul class="f_contact">
                        <li>49 Archdale, 2B Charlestone</li>
                        <li>+777 (100) 1234</li>
                        <li>mail@example.com</li>
                    </ul><!-- .f_contact -->
                </div><!-- .grid_3 -->

                <div class="grid_3">
                    <h3>Information</h3>
                    <nav class="f_menu">
                        <ul>
                            <li><a href="#">About As</a></li>
                            <li><a href="#">Privacy Policy</a></li>
                            <li><a href="#">Terms & Conditions</a></li>
                            <li><a href="#">Secure payment</a></li>
                        </ul>
                    </nav><!-- .private -->
                </div><!-- .grid_3 -->

                <div class="grid_3">
                    <h3>Costumer Servise</h3>
                    <nav class="f_menu">
                        <ul>
                            <li><a href="#">Contact As</a></li>
                            <li><a href="#">Return</a></li>
                            <li><a href="#">FAQ</a></li>
                            <li><a href="#">Site Map</a></li>
                        </ul>
                    </nav><!-- .private -->
                </div><!-- .grid_3 -->

                <div class="grid_3">
                    <h3>My Account</h3>
                    <nav class="f_menu">
                        <ul>
                            <li><a href="#">My Account</a></li>
                            <li><a href="#">Order History</a></li>
                            <li><a href="#">Wish List</a></li>
                            <li><a href="#">Newsletter</a></li>
                        </ul>
                    </nav><!-- .private -->
                </div><!-- .grid_3 -->
                
                <div class="grid_12 newsletter-payments">
                    <div class="newsletter">
                        <div class="icon-mail">Newsletter</div>
                        <p>Subscribe to notifications about discounts from our store</p>
                        <form>
                            <input type="submit" value="">
                            <input type="email" name="newsletter" value="" placeholder="Enter your email address...">
                        </form>                    
                    </div><!-- .newsletter -->
                    
                    <div class="payments">
                        <img src="img/payments.png" alt="Payments">
                    </div><!-- .payments -->
                </div><!-- .grid_12.newsletter-payments -->

                <div class="clear"></div>
            </div><!-- .container_12 -->
        </div><!-- .footer_navigation -->

        <div class="footer_info">
            <div class="container_12">
                <div class="grid_6">
                    <p class="copyright">Â© Diamond Store Theme, 2013.More Templates <a href="http://www.cssmoban.com/" target="_blank" title="æ¨¡æ¿ä¹å®¶">æ¨¡æ¿ä¹å®¶</a> - Collect from <a href="http://www.cssmoban.com/" title="ç½é¡µæ¨¡æ¿" target="_blank">ç½é¡µæ¨¡æ¿</a></p>
                </div><!-- .grid_6 -->

                <div class="grid_6">
                    <div class="soc">
                        <a class="google" href="#"></a>
                        <a class="twitter" href="#"></a>
                        <a class="facebook" href="#"></a>
                    </div><!-- .soc -->
                </div><!-- .grid_6 -->

                <div class="clear"></div>
            </div><!-- .container_12 -->
        </div><!-- .footer_info -->
    </footer>
</body>
<!-- Added by HTTrack --><meta http-equiv="content-type" content="text/html;charset=utf-8" /><!-- /Added by HTTrack -->
</html>
