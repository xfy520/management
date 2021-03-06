var prefix = ctx + "info/exam";

function submitHandler() {
    if ($.validate.form()) {
        $('#examClass').prop('disabled', false);
        var data = $("#" + fromId).serializeArray();
        var classIds = $.form.selectSelects("examClass");
        var subjectIds = $.form.selectSelects("examSubject");
        data.push({"name": "classIds", "value": classIds});
        data.push({"name": "subjectIds", "value": subjectIds});
        $.operate.save(prefix + postUrl, data);
    }
}

$(function(){
    $("#examName").val($("#examType option:selected").text() + "考试");

    $('#examSubject').select2({
        data: subjectList
    });

    subjectIds != null ? $('#examSubject').val(subjectIds).trigger("change") : null;

    $('#examClass').select2({
        data: $("#examType option:selected").val() == 1 ? [{id: grade, text: '全年级', selected: true}] : classList
    });

    classIds != null ? $('#examClass').val(classIds).trigger("change") : null;

    $("#examType option:selected").val() == 1 ? $('#examClass').prop('disabled', true) : $('#examClass').prop('disabled', false);

    $("#examType").selectpicker({
        "virtualScroll": 10,
        "liveSearch": false,
        "size": 10
    });

    $('#examType').on('changed.bs.select', function () {
        $('#examClass').val("");
        $("#examClass").attr("title","");
        $("#examClass").empty();
        $("#examName").val($("#examType option:selected").text() + "考试");
        $('#examClass').select2({
            data: $("#examType option:selected").val() == 1 ? [{id: grade, text: '全年级', selected: true}] : classList
        });

        $("#examType option:selected").val() == 1 ? $('#examClass').prop('disabled', true) : $('#examClass').prop('disabled', false);
    });

    layui.use("laydate", function() {
        var laydate = layui.laydate;
        var startDate = laydate.render({
            elem: "#startDate",
            format: "yyyy-MM-dd HH:mm",
            type: "datetime",
            max: 150,
            min: 0,
            value: startDateValue,
            theme: "molv",
            trigger: "click",
            done: function (value, date) {
                var now = new Date(new Date(format('{0}-{1}-{2}T{3}:{4}:{5}', [date.year, date.month, date.date, date.hours,
                    date.minutes, date.seconds])).getTime() + 1000*60*30);
                $('#endDate').val(formatDateTime(now));
                // 结束时间大于开始时间
                if (value !== '') {
                    endDate.config.min.year = now.getFullYear();
                    endDate.config.min.month = now.getMonth();
                    endDate.config.min.date = now.getDate();
                    endDate.config.min.hours = now.getHours();
                    endDate.config.min.minutes = now.getMinutes();
                } else {
                    endDate.config.min.year = '';
                    endDate.config.min.month = '';
                    endDate.config.min.date = '';
                    endDate.config.min.hours = '';
                    endDate.config.min.minutes = '';
                }
            }
        });

        var endDate = laydate.render({
            elem: "#endDate",
            format: "yyyy-MM-dd HH:mm",
            type: "datetime",
            min: $("#startDate").val(),
            theme: "molv",
            value: endDateValue == null ? formatDateTime(new Date(new Date().getTime() + 1000*60*30)) : endDateValue,
            trigger: "click",
            btns: ["clear", "confirm"],
            done: function (value, date) {
                // 开始时间小于结束时间
                if (value !== '') {
                    startDate.config.max.year = date.year;
                    startDate.config.max.month = date.month - 1;
                    startDate.config.max.date = date.date;
                    startDate.config.min.hours = date.hours;
                    startDate.config.min.minutes = date.minutes;
                } else {
                    startDate.config.max.year = '';
                    startDate.config.max.month = '';
                    startDate.config.max.date = '';
                    startDate.config.max.hours = '';
                    startDate.config.max.minutes = '';
                }
            }
        });
    });

    function format (result, data) {
        for (var key in data) {
            var value = data[key];
            if (undefined != value) {
                result = result.replace("{" + key + "}", value < 10 ? `0${value}`: value);
            }
        }
        return result;
    }

    function formatDateTime (date) {
        return format('{0}-{1}-{2} {3}:{4}', [date.getFullYear(), date.getMonth() + 1, date.getDate(), date.getHours(),
            date.getMinutes()]);
    }
})