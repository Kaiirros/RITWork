

<nav class="subnav">
					<ol class="nav nav-list container-fluid nav-collapse collapse in">
						<li <?php if ($page == "home"){echo 'class="active"';} ?> ><a href="<?php echo $path;?>index.php">Home</a></li>
						<li <?php if ($page == "people"){echo 'class="active"';} ?> ><a href="<?php echo $path;?>people/index.php">Our People</a></li>
						<li <?php if ($page == "tour"){echo 'class="active"';} ?> ><a href="<?php echo $path;?>tour/index.php">Tour</a></li>
                        <li <?php if ($page == "about"){echo 'class="active"';} ?> ><a href="<?php echo $path;?>about/about.php">About</a></li>
					</ol>
				</nav><!-- end subnav -->