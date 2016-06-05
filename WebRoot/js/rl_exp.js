/*
*	���۱�����ȾJS
*	@author:	Сë(΢����BUPT��Сë)
*	@data:		2013��2��17��
*	@version:	1.0
*	@rely:		jQuery
*/
$(function(){
	/*
	*		����˵��
	*		baseUrl:	���ַ���������·���Ļ���ַ
	*		pace:		�����֡����鵯���㵭�뵭�����ٶ�
	*		dir:		�����顿���������ļ�������
	*		text:		����ά���顿��������title����
	*		num:		�����顿���������������
	*		isExist:	�����顿��������Ƿ���ع�,���ڼ��ع��ı�������ظ�����
	*/
	var rl_exp = {
		baseUrl:	'',
		pace:		200,
		dir:		['mr','gnl','lxh','bzmh'],
		text:[			/*�����title���֣��Լ�����*/
			[
				'1','2','3','4','5','6','7','8','9','10','11','12','13','14','15','16','17','18','19','20',
				'21','22','23','24','25','26','27','28','29','30','31','32','33','34','35','36','37','38','39','40',
				'41','42','43','44','45','46','47','48','49','50','51','52','53','54','55','56','57','58','59','60',
				'61','62','63','64','65','66','67','68','69','70','71','72','73','74','75','76','77','78','79','80',
				'81','82','83','84','85','86','87','88','89','90','91','92','93','94','95','96'
			],
			[
				'1','2','3','4','5','6','7','8','9','10','11','12','13','14','15','16','17','18','19','20',
				'21','22','23','24','25','26','27','28','29','30','31','32','33','34','35','36','37','38','39','40',
				'41','42','43','44','45','46','47','48','49','50','51','52','53','54','55','56','57','58','59','60',
				'61','62','63','64','65','66','67','68','69','70','71','72','73','74','75','76','77','78','79','80',
				'81','82','83','84','85','86','87','88','89','90','91','92','93','94','95','96'
			],
			[
				'1','2','3','4','5','6','7','8','9','10','11','12','13','14','15','16','17','18','19','20',
				'21','22','23','24','25','26','27','28','29','30','31','32','33','34','35','36','37','38','39','40',
				'41','42','43','44','45','46','47','48','49','50','51','52','53','54','55','56','57','58','59','60',
				'61','62','63','64','65','66','67','68','69','70','71','72','73','74','75','76','77','78','79','80',
				'81','82','83','84','85','86','87','88','89','90','91','92','93','94','95','96'
			],
			[
				'1','2','3','4','5','6','7','8','9','10','11','12','13','14','15','16','17','18','19','20',
				'21','22','23','24','25','26','27','28','29','30','31','32','33','34','35','36','37','38','39','40',
				'41','42','43','44','45','46','47','48','49','50','51','52','53','54','55','56','57','58','59','60',
				'61','62','63','64','65','66','67','68','69','70','71','72','73','74','75','76','77','78','79','80',
				'81','82','83','84','85','86','87','88','89','90','91','92','93','94','95','96'
			]
		],
		num:		[84,46,82,69],
		isExist:	[0,0,0,0],
		bind:	function(i){
			$("#rl_bq .rl_exp_main").eq(i).find('.rl_exp_item').each(function(){
				$(this).bind('click',function(){
					rl_exp.insertText(document.getElementById('rl_exp_input'),'['+$(this).find('img').attr('title')+']');
					$('#rl_bq').fadeOut(rl_exp.pace);
				});
			});
		},
		/*���ر��������*/
		loadImg:function(i){
			var node = $("#rl_bq .rl_exp_main").eq(i);
			for(var j = 0; j<rl_exp.num[i];j++){
				var domStr = 	'<li class="rl_exp_item">' + 
									'<img src="' + rl_exp.baseUrl + 'images/' + rl_exp.dir[i] + '/' + j + '.gif" alt="' + rl_exp.text[i][j] + 
									'" title="' + rl_exp.text[i][j] + '" />' +
								'</li>';
				$(domStr).appendTo(node);
			}
			rl_exp.isExist[i] = 1;
			rl_exp.bind(i);
		},
		/*��textarea��������������*/
		insertText:function(obj,str){
			obj.focus();
			if (document.selection) {
				var sel = document.selection.createRange();
				sel.text = str;
			} else if (typeof obj.selectionStart == 'number' && typeof obj.selectionEnd == 'number') {
				var startPos = obj.selectionStart,
					endPos = obj.selectionEnd,
					cursorPos = startPos,
					tmpStr = obj.value;
				obj.value = tmpStr.substring(0, startPos) + str + tmpStr.substring(endPos, tmpStr.length);
				cursorPos += str.length;
				obj.selectionStart = obj.selectionEnd = cursorPos;
			} else {
				obj.value += str;
			}
		},
		init:function(){
			$("#rl_bq > ul.rl_exp_tab > li > a").each(function(i){
				$(this).bind('click',function(){
					if( $(this).hasClass('selected') )
						return;
					if( rl_exp.isExist[i] == 0 ){
						rl_exp.loadImg(i);
					}
					$("#rl_bq > ul.rl_exp_tab > li > a.selected").removeClass('selected');
					$(this).addClass('selected');
					$('#rl_bq .rl_selected').removeClass('rl_selected').hide();
					$('#rl_bq .rl_exp_main').eq(i).addClass('rl_selected').show();
				});
			});
			/*�󶨱��鵯����ť��Ӧ����ʼ������Ĭ�ϱ��顣*/
			$("#rl_exp_btn").bind('click',function(){
				if( rl_exp.isExist[0] == 0 ){
					rl_exp.loadImg(0);
				}
				var w = $(this).position();
				$('#rl_bq').css({left:w.left,top:w.top+30}).fadeIn(400);
			});
			/*�󶨹رհ�ť*/
			$('#rl_bq a.close').bind('click',function(){
				$('#rl_bq').fadeOut(rl_exp.pace);
			});
			/*��document����¼�����target����rl_bq��������ʱִ��rl_bq����������ֹtarget�ڵ�����ť����Ӧ��*/
			$(document).bind('click',function(e){
				var target = $(e.target);
				if( target.closest("#rl_exp_btn").length == 1 )
					return;
				if( target.closest("#rl_bq").length == 0 ){
					$('#rl_bq').fadeOut(rl_exp.pace);
				}
			});
		}
	};
	rl_exp.init();	//���ó�ʼ��������
});