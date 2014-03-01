var abc;
function drawBarChart(data, valueName, containerSelector, options){
	
	container = d3.select(containerSelector);
	//isolate variables FIXME
	
	var barHeight, maxBarWidth, colorsScale, valueLabelWidth, barLabelWidth,
		barLabelPadding, gridLabelHeight, gridChartOffset;
	
	options.barHeight === undefined ?
			barHeight = 40 :
			barHeight = options.barHeight; // height of the bars
	options.maxBarWidth === undefined ?
			maxBarWidth = 200 :
			maxBarWidth = options.maxBarWidth; // max width of the bars
	options.colorsScale === undefined ?
			colorsScale = d3.scale.category10() :
			colorsScale = options.colorsScale; // scale of colors used in the bars
	options.valueLabelWidth === undefined ?
			valueLabelWidth = 40 :
			valueLabelWidth = options.valueLabelWidth; // space reserved for value labels (right)
	options.barLabelWidth === undefined ?
			barLabelWidth = 50 :
			barLabelWidth = options.barLabelWidth; // space reserved for bar labels
	options.barLabelPadding === undefined ?
			barLabelPadding = 5 :
			barLabelPadding = options.barLabelPadding; // padding between bar and bar labels (left)
	options.gridLabelHeight === undefined ?
			gridLabelHeight = 18 :
			gridLabelHeight = options.gridLabelHeight; // space reserved for gridline labels
	options.gridChartOffset === undefined ?
			gridChartOffset = 3 :
			gridChartOffset = options.gridChartOffset; // space between start of grid and first bar
	
	if(maxBarWidth <= 1){
		maxBarWidth = Math.floor(window.innerWidth * maxBarWidth)
						- barLabelWidth - valueLabelWidth;
	}
	
//accessor function
	var barLabel = function(d) { return d['category']; };
	var barValue = function(d) { return parseFloat(d[valueName]); };
	var riskDesc = function(d) { return d['desc']; };
	
//sorting
	var sortedData = data.sort(function(a, b) {
		return d3.ascending(barValue(a), barValue(b)); 
	});
	
//scales
	var yScale = d3.scale.ordinal().domain(d3.range(0, data.length)).rangeBands([0, data.length * barHeight]);
	var y = function(d, i) { return yScale(i); };
	var yText = function(d, i) { return y(d, i) + yScale.rangeBand() / 2; };
	var x = d3.scale.linear().domain([0, d3.max(data, barValue)]).range([0, maxBarWidth]);
// svg container element
	var chart = container.append("svg")
	.attr('width', maxBarWidth + barLabelWidth + valueLabelWidth)
	.attr('height', gridLabelHeight + gridChartOffset + data.length * barHeight);
	
// grid line labels
	var gridContainer = chart.append('g').classed("gridContainer", true)
	.attr('transform', 'translate(' + barLabelWidth + ',' + gridLabelHeight + ')'); 
	gridContainer.selectAll("text").data(x.ticks(10)).enter().append("text")
	.attr("x", x)
	.attr("dy", -3)
	.attr("text-anchor", "middle")
	.style("fill", "#ddd")
	.text(String);
// vertical grid lines
	gridContainer.selectAll("line").data(x.ticks(10)).enter().append("line")
	.attr("x1", x)
	.attr("x2", x)
	.attr("y1", 0)
	.attr("y2", yScale.rangeExtent()[1] + gridChartOffset)
	.style("stroke", "#ddd");
	
// bar labels
	var labelsContainer = chart.append('g').classed("labelsContainer", true)
	.attr('transform', 'translate(' + (barLabelWidth - barLabelPadding) + ',' + (gridLabelHeight + gridChartOffset) + ')'); 
	labelsContainer.selectAll('text').data(data).enter().append('text')
	.attr('y', yText)
	.attr("dy", ".35em") // vertical-align: middle
	.attr('text-anchor', 'end')
	.classed("bar-labels", true)
	.on("mouseover", function(d) {
		//Update the tooltip position and value
		d3.select("#tooltip")
		.style("left", d3.event.pageX + "px")
		.style("top", d3.event.pageY + "px")
		.select(".risk-name")
		.text(barLabel(d));
		d3.select("#tooltip .risk-desc")
		.html(riskDesc(d));
		//Show the tooltip
		d3.select("#tooltip").classed("hidden", false);
	})
	.on("mousemove", function() {
		d3.select("#tooltip")
		.style("left", d3.event.pageX + "px")
		.style("top", d3.event.pageY + "px");
	})
	.on("mouseout", function() {
		//Hide the tooltip
		d3.select("#tooltip").classed("hidden", true);
	})
	.text(barLabel);
	if(containerSelector == '#vis'){
		labelsContainer.selectAll('text').on("click", function(d,i) {
			changeDetails(barLabel(d),colorsScale(i));
		});
	}
	
// bar container
	var barsContainer = chart.append('g').classed("barsContainer", true)
	.attr('transform', 'translate(' + barLabelWidth + ',' + (gridLabelHeight + gridChartOffset) + ')'); 
// bars
	barsContainer.selectAll("rect").data(data).enter().append("rect")
	.attr('y', y)
	.attr('height', yScale.rangeBand())
	.attr('width', function(d) { return x(barValue(d)); })
	.classed("bar", true)
	.attr("fill",function(d,i){return colorsScale(i);})
	.on("mouseover", function(d) {
		//Update the tooltip position and value
		d3.select("#tooltip")
		.style("left", d3.event.pageX + "px")
		.style("top", d3.event.pageY + "px")
		.select(".risk-name")
		.text(barLabel(d));
		d3.select("#tooltip .risk-desc")
		.html(riskDesc(d));
		//Show the tooltip
		d3.select("#tooltip").classed("hidden", false);
	})
	.on("mousemove", function() {
		d3.select("#tooltip")
		.style("left", d3.event.pageX + "px")
		.style("top", d3.event.pageY + "px");
	})
	.on("mouseout", function() {
		//Hide the tooltip
		d3.select("#tooltip").classed("hidden", true);
	});
	if(containerSelector == '#vis'){
		barsContainer.selectAll("rect").on("click", function(d,i) {
			changeDetails(barLabel(d),colorsScale(i));
		});
	}
// bar value labels
	barsContainer.selectAll("text").data(sortedData).enter().append("text")
	.attr("x", function(d) { return x(barValue(d)); })
	.attr("y", yText)
	.attr("dx", 3) // padding-left
	.attr("dy", ".35em") // vertical-align: middle
	.attr("text-anchor", "start") // text-align: right
	.classed("bar-value-label", true)
	.text(function(d) { return d3.round(barValue(d), 2); });
// start line
	barsContainer.append("line")
	.attr("y1", -gridChartOffset)
	.attr("y2", yScale.rangeExtent()[1] + gridChartOffset)
	.style("stroke", "#444");
	
}


function changeByJourney(){
	updateVis(d3.selectAll('#vis svg rect').data(), 'byjourney');
	d3.selectAll('#vis p.explanation').remove();
	d3.select('#vis').append('p').html(journeyExplanation).classed("explanation" , true);
}
function changeByKm(){
	updateVis(d3.selectAll('#vis svg rect').data(),'bykm');
	d3.selectAll('#vis p.explanation').remove();
	d3.select('#vis').append('p').html(kmExplanation).classed("explanation" , true);
}
function changeByHour(){
	updateVis(d3.selectAll('#vis svg rect').data(), 'byhour');
	d3.selectAll('#vis p.explanation').remove();
	d3.select('#vis').append('p').html(hourExplanation).classed("explanation" , true);
}

function updateVis(data, valueName){
	//accessor function
	var barValue = function(d) { return parseFloat(d[valueName]); };
	
	sortItems = function(a, b) {
		  return barValue(a) - barValue(b); 
	};
	
	var yScale = d3.scale.ordinal().domain(d3.range(0, data.length)).rangeBands([0, data.length * barHeight]);
	var y = function(d, i) { return yScale(i); };
	var yText = function(d, i) { return y(d, i) + yScale.rangeBand() / 2; };
	var x = d3.scale.linear().domain([0, d3.max(data, barValue)]).range([0, maxBarWidth]);
	
	x.domain([0, d3.max(data, barValue)]);
	
	barsContainer = d3.select('#vis #barsContainer');
	barsContainer.selectAll("rect").sort(sortItems)
	.transition()
	.delay(function (d, i) {return i * 50;})
    .attr('y', y)
	.attr('height', yScale.rangeBand())
	.attr('width', function(d) { return x(barValue(d)); });
	
	gridContainer = d3.select('#vis #gridContainer');
	gridContainer.selectAll("text").remove();
	gridContainer.selectAll("line").remove();
	gridContainer.selectAll("text").data(x.ticks(10)).enter().append("text")
	  .attr("x", x)
	  .attr("dy", -3)
	  .attr("text-anchor", "middle")
	  .style("fill", "#aaa")
	  .text(String);
	gridContainer.selectAll("line").data(x.ticks(10)).enter().append("line")
	  .attr("x1", x)
	  .attr("x2", x)
	  .attr("y1", 0)
	  .attr("y2", yScale.rangeExtent()[1] + gridChartOffset)
	  .style("stroke", "#ddd");
	
	labelsContainer = d3.select('#vis #labelsContainer').selectAll('text').sort(sortItems)
	.transition()
	.delay(function (d, i) {return i * 50;})
	.attr('y', yText);
	
	barsContainer.selectAll("text").sort(sortItems)
	.transition()
	.delay(function (d, i) {return i * 50;})
	.attr("x", function(d) { return x(barValue(d)); })
	.attr("y", yText)
	.text(function(d) { return d3.round(barValue(d), 2); });
}




function changeDetails(risk_name, color) {
	$('#detail').toggle('slide', function(){
		text = d3.select('#risks-detail .'+risk_name).html();
		d3.select('#detail').html(text).style("background",color);
		if(risk_name == 'Car') {drawCarGraph();}
	});
	$('#detail').toggle('slide');
}
