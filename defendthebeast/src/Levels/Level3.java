package Levels;

import dtb.DefendGameView;

public class Level3 extends DefendGameView {

	private static int[] x = new int[] { 4, 30, 55, 81, 107, 136, 163, 190,
			217, 244, 269, 298, 327, 355, 389, 420, 452, 479, 511, 537, 567,
			596, 624, 651, 677, 707, 740, 772, 798, 823, 849, 878, 906, 931,
			953, 975, 985, 991, 992, 983, 956, 929, 896, 860, 822, 786, 753,
			719, 695, 663, 631, 601, 568, 537, 508, 482, 455, 426, 394, 363,
			338, 312, 291, 279, 273, 273, 283, 298, 312, 332, 355, 381, 409,
			437, 467, 493, 523, 551, 583, 616, 645, 670, 703, 733, 766, 792,
			814, 829, 839, 847, 852, 853, 851, 841, 827, 812, 793, 767, 738,
			704, 674, 646, 617, 591, 563, 531, 501, 475, 451, 428, 408, 396,
			385, 373, 359, 344, 323, 303, 278, 252, 228, 204, 178, 155, 132,
			115, 102, 94, 102, 123, 149, 176, 205, 230, 264, 294, 323, 349,
			375, 400, 427, 458, 486, 512, 538, 565, 594, 625, 653, 685, 711,
			737, 763, 795, 828, 858, 888, 914, 942, 975, 1004, 1030, 1056,
			1080, 1105, 1127, 1148, 1162, 1177, 1187, 1196, 1207, 1213, 1213,
			1205, 1193, 1178, 1162, 1143, 1122, 1095, 1071, 1045, 1018, 992,
			957, 923, 889, 862, 836, 807, 779, 754, 725, 699, 673, 644, 611,
			580, 554, 528, 496, 469, 443, 414, 388, 360, 334, 309, 284, 260,
			237, 214, 194, 193, 200, 203, 213, 221, 226, 230 };

	private static int[] y = new int[] { 64, 62, 55, 50, 47, 46, 46, 44, 43,
			40, 38, 38, 38, 35, 35, 35, 35, 35, 35, 35, 35, 35, 35, 35, 35, 35,
			35, 35, 35, 42, 49, 64, 76, 88, 103, 122, 149, 176, 202, 227, 241,
			250, 257, 259, 259, 259, 259, 259, 251, 242, 231, 218, 204, 194,
			185, 175, 174, 174, 174, 178, 187, 198, 213, 235, 261, 294, 318,
			339, 363, 386, 404, 422, 435, 447, 460, 471, 479, 489, 497, 505,
			510, 514, 519, 519, 516, 506, 492, 467, 438, 414, 389, 357, 330,
			305, 276, 254, 233, 218, 208, 200, 196, 193, 193, 193, 193, 193,
			197, 204, 213, 226, 244, 270, 295, 321, 346, 370, 385, 401, 413,
			414, 405, 389, 369, 350, 329, 309, 287, 263, 236, 221, 213, 209,
			203, 201, 195, 191, 186, 181, 177, 173, 168, 163, 161, 161, 161,
			161, 161, 161, 161, 161, 161, 161, 161, 161, 161, 161, 161, 161,
			161, 165, 169, 173, 181, 190, 202, 215, 232, 255, 280, 303, 329,
			353, 379, 405, 431, 458, 479, 499, 516, 532, 548, 557, 566, 574,
			576, 576, 576, 576, 576, 573, 569, 567, 564, 564, 564, 562, 559,
			559, 559, 559, 559, 559, 559, 559, 559, 559, 559, 561, 565, 572,
			580, 590, 602, 619, 645, 671, 697, 721, 745, 770, 795 };

	private static int[][] waves ={ 
			{ 1, 1, 1, 1, 1 }, // wave1
			{ 2, 2, 2, 2, 2 }, // wave2
			{ 3, 3, 3, 3, 3 }, // wave3
			{ 4, 4, 4, 4, 4 }, // wave4
			{ 5, 5, 5, 5, 5, 101, 102 },// wave5
	};

	public Level3() {
		super("Levels/Level3.png", x, y, waves);

		// 1=Enemy1 2=Enemy2.... 101=Boss1 102=Boss2

	}
}
