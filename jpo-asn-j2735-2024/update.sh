#!/usr/bin/env bash

BRANCH=j2735-2024-type-refactor-everything
PACKAGE=src/main/java/us/dot/its/jpo/asn/j2735/r2024

echo "Checkout files from $BRANCH"

# echo on
set -x

############################################################################################# Part 1

git checkout $BRANCH ${PACKAGE}/AddGrpB/DegreesLat.java
git checkout $BRANCH ${PACKAGE}/AddGrpB/DegreesLong.java
git checkout $BRANCH ${PACKAGE}/AddGrpB/Elevation.java
git checkout $BRANCH ${PACKAGE}/AddGrpB/LatitudeDMS.java
git checkout $BRANCH ${PACKAGE}/AddGrpB/LatitudeDMS2.java
git checkout $BRANCH ${PACKAGE}/AddGrpB/LongitudeDMS.java
git checkout $BRANCH ${PACKAGE}/AddGrpB/LongitudeDMS2.java
git checkout $BRANCH ${PACKAGE}/AddGrpB/MaxTimetoChange.java
git checkout $BRANCH ${PACKAGE}/AddGrpB/MinTimetoChange.java
git checkout $BRANCH ${PACKAGE}/AddGrpB/MinutesAngle.java
git checkout $BRANCH ${PACKAGE}/AddGrpB/MovementEvent_addGrpB.java
git checkout $BRANCH ${PACKAGE}/AddGrpB/MovementEvent_addGrpBReg_MovementEvent.java
git checkout $BRANCH ${PACKAGE}/AddGrpB/MovementEvent_addGrpBReg_MovementEventValueDeserializer.java
git checkout $BRANCH ${PACKAGE}/AddGrpB/MovementEvent_addGrpBReg_MovementEventValueSerializer.java
git checkout $BRANCH ${PACKAGE}/AddGrpB/NodeOffsetPointXY_addGrpB.java
git checkout $BRANCH ${PACKAGE}/AddGrpB/NodeOffsetPointXY_addGrpBReg_NodeOffsetPointXY.java
git checkout $BRANCH ${PACKAGE}/AddGrpB/NodeOffsetPointXY_addGrpBReg_NodeOffsetPointXYValueDeserializer.java
git checkout $BRANCH ${PACKAGE}/AddGrpB/NodeOffsetPointXY_addGrpBReg_NodeOffsetPointXYValueSerializer.java
git checkout $BRANCH ${PACKAGE}/AddGrpB/Node_LLdms_48b.java
git checkout $BRANCH ${PACKAGE}/AddGrpB/Node_LLdms_80b.java
git checkout $BRANCH ${PACKAGE}/AddGrpB/Position3D_addGrpB.java
git checkout $BRANCH ${PACKAGE}/AddGrpB/Position3D_addGrpBReg_Position3D.java
git checkout $BRANCH ${PACKAGE}/AddGrpB/Position3D_addGrpBReg_Position3DValueDeserializer.java
git checkout $BRANCH ${PACKAGE}/AddGrpB/Position3D_addGrpBReg_Position3DValueSerializer.java
git checkout $BRANCH ${PACKAGE}/AddGrpB/SecondsAngle.java
git checkout $BRANCH ${PACKAGE}/AddGrpB/TimeRemaining.java



git checkout $BRANCH ${PACKAGE}/AddGrpC/Altitude.java
git checkout $BRANCH ${PACKAGE}/AddGrpC/AltitudeConfidence.java
git checkout $BRANCH ${PACKAGE}/AddGrpC/AltitudeValue.java
git checkout $BRANCH ${PACKAGE}/AddGrpC/ConnectionManeuverAssist_addGrpC.java
git checkout $BRANCH ${PACKAGE}/AddGrpC/ConnectionManeuverAssist_addGrpCReg_ConnectionManeuverAssist.java
git checkout $BRANCH ${PACKAGE}/AddGrpC/ConnectionManeuverAssist_addGrpCReg_ConnectionManeuverAssistValueDeserializer.java
git checkout $BRANCH ${PACKAGE}/AddGrpC/ConnectionManeuverAssist_addGrpCReg_ConnectionManeuverAssistValueSerializer.java
git checkout $BRANCH ${PACKAGE}/AddGrpC/IntersectionState_addGrpC.java
git checkout $BRANCH ${PACKAGE}/AddGrpC/IntersectionState_addGrpCReg_IntersectionState.java
git checkout $BRANCH ${PACKAGE}/AddGrpC/IntersectionState_addGrpCReg_IntersectionStateValueDeserializer.java
git checkout $BRANCH ${PACKAGE}/AddGrpC/IntersectionState_addGrpCReg_IntersectionStateValueSerializer.java
git checkout $BRANCH ${PACKAGE}/AddGrpC/Position3D_addGrpC.java
git checkout $BRANCH ${PACKAGE}/AddGrpC/Position3D_addGrpCReg_Position3D.java
git checkout $BRANCH ${PACKAGE}/AddGrpC/Position3D_addGrpCReg_Position3DValueDeserializer.java
git checkout $BRANCH ${PACKAGE}/AddGrpC/Position3D_addGrpCReg_Position3DValueSerializer.java
git checkout $BRANCH ${PACKAGE}/AddGrpC/PrioritizationResponse.java
git checkout $BRANCH ${PACKAGE}/AddGrpC/PrioritizationResponseList.java
git checkout $BRANCH ${PACKAGE}/AddGrpC/VehicleToLanePosition.java
git checkout $BRANCH ${PACKAGE}/AddGrpC/VehicleToLanePositionList.java



git checkout $BRANCH ${PACKAGE}/Common/Angle.java
git checkout $BRANCH ${PACKAGE}/Common/ApproachID.java
git checkout $BRANCH ${PACKAGE}/Common/BasicVehicleRole.java
git checkout $BRANCH ${PACKAGE}/Common/DSecond.java
git checkout $BRANCH ${PACKAGE}/Common/DescriptiveName.java
git checkout $BRANCH ${PACKAGE}/Common/Elevation.java
git checkout $BRANCH ${PACKAGE}/Common/FullRoadAuthorityID.java
git checkout $BRANCH ${PACKAGE}/Common/IntersectionAccessPoint.java
git checkout $BRANCH ${PACKAGE}/Common/IntersectionID.java
git checkout $BRANCH ${PACKAGE}/Common/IntersectionReferenceID.java
git checkout $BRANCH ${PACKAGE}/Common/Iso3833VehicleType.java
git checkout $BRANCH ${PACKAGE}/Common/LaneConnectionID.java
git checkout $BRANCH ${PACKAGE}/Common/LaneID.java
git checkout $BRANCH ${PACKAGE}/Common/Latitude.java
git checkout $BRANCH ${PACKAGE}/Common/Longitude.java
git checkout $BRANCH ${PACKAGE}/Common/MinuteOfTheYear.java
git checkout $BRANCH ${PACKAGE}/Common/MsgCount.java
git checkout $BRANCH ${PACKAGE}/Common/NodeOffsetPointXY.java
git checkout $BRANCH ${PACKAGE}/Common/Node_LLmD_64b.java
git checkout $BRANCH ${PACKAGE}/Common/Node_XY_20b.java
git checkout $BRANCH ${PACKAGE}/Common/Node_XY_22b.java
git checkout $BRANCH ${PACKAGE}/Common/Node_XY_24b.java
git checkout $BRANCH ${PACKAGE}/Common/Node_XY_26b.java
git checkout $BRANCH ${PACKAGE}/Common/Node_XY_28b.java
git checkout $BRANCH ${PACKAGE}/Common/Node_XY_32b.java
git checkout $BRANCH ${PACKAGE}/Common/Offset_B09.java
git checkout $BRANCH ${PACKAGE}/Common/Offset_B10.java
git checkout $BRANCH ${PACKAGE}/Common/Offset_B11.java
git checkout $BRANCH ${PACKAGE}/Common/Offset_B12.java
git checkout $BRANCH ${PACKAGE}/Common/Offset_B13.java
git checkout $BRANCH ${PACKAGE}/Common/Offset_B14.java
git checkout $BRANCH ${PACKAGE}/Common/Offset_B16.java
git checkout $BRANCH ${PACKAGE}/Common/Position3D.java
git checkout $BRANCH ${PACKAGE}/Common/PrioritizationResponseStatus.java
git checkout $BRANCH ${PACKAGE}/Common/RegionId.java
git checkout $BRANCH ${PACKAGE}/Common/RegionalExtension.java
git checkout $BRANCH ${PACKAGE}/Common/RelativeRoadAuthorityID.java
git checkout $BRANCH ${PACKAGE}/Common/RequestID.java
git checkout $BRANCH ${PACKAGE}/Common/RequestImportanceLevel.java
git checkout $BRANCH ${PACKAGE}/Common/RequestSubRole.java
git checkout $BRANCH ${PACKAGE}/Common/RequestorType.java
git checkout $BRANCH ${PACKAGE}/Common/RestrictionClassID.java
git checkout $BRANCH ${PACKAGE}/Common/RoadAuthorityID.java
git checkout $BRANCH ${PACKAGE}/Common/RoadRegulatorID.java
git checkout $BRANCH ${PACKAGE}/Common/SignalGroupID.java
git checkout $BRANCH ${PACKAGE}/Common/SpeedConfidence.java
git checkout $BRANCH ${PACKAGE}/Common/StationID.java
git checkout $BRANCH ${PACKAGE}/Common/TemporaryID.java
git checkout $BRANCH ${PACKAGE}/Common/TransmissionAndSpeed.java
git checkout $BRANCH ${PACKAGE}/Common/TransmissionState.java
git checkout $BRANCH ${PACKAGE}/Common/VehicleID.java
git checkout $BRANCH ${PACKAGE}/Common/VehicleType.java
git checkout $BRANCH ${PACKAGE}/Common/Velocity.java


git checkout $BRANCH ${PACKAGE}/REGION/Reg_AdvisorySpeed.java
git checkout $BRANCH ${PACKAGE}/REGION/Reg_ConnectionManeuverAssist.java
git checkout $BRANCH ${PACKAGE}/REGION/Reg_IntersectionState.java
git checkout $BRANCH ${PACKAGE}/REGION/Reg_MovementEvent.java
git checkout $BRANCH ${PACKAGE}/REGION/Reg_MovementState.java
git checkout $BRANCH ${PACKAGE}/REGION/Reg_NodeOffsetPointXY.java
git checkout $BRANCH ${PACKAGE}/REGION/Reg_Position3D.java
git checkout $BRANCH ${PACKAGE}/REGION/Reg_RequestorDescription.java
git checkout $BRANCH ${PACKAGE}/REGION/Reg_RequestorType.java
git checkout $BRANCH ${PACKAGE}/REGION/Reg_SPAT.java
git checkout $BRANCH ${PACKAGE}/REGION/Reg_SignalRequest.java
git checkout $BRANCH ${PACKAGE}/REGION/Reg_SignalRequestMessage.java
git checkout $BRANCH ${PACKAGE}/REGION/Reg_SignalRequestPackage.java
git checkout $BRANCH ${PACKAGE}/REGION/Reg_SignalStatus.java
git checkout $BRANCH ${PACKAGE}/REGION/Reg_SignalStatusMessage.java
git checkout $BRANCH ${PACKAGE}/REGION/Reg_SignalStatusPackage.java


git checkout $BRANCH ${PACKAGE}/SPAT/AdvisorySpeed.java
git checkout $BRANCH ${PACKAGE}/SPAT/AdvisorySpeedList.java
git checkout $BRANCH ${PACKAGE}/SPAT/AdvisorySpeedType.java
git checkout $BRANCH ${PACKAGE}/SPAT/ConnectionManeuverAssist.java
git checkout $BRANCH ${PACKAGE}/SPAT/EnabledLaneList.java
git checkout $BRANCH ${PACKAGE}/SPAT/IntersectionState.java
git checkout $BRANCH ${PACKAGE}/SPAT/IntersectionStateList.java
git checkout $BRANCH ${PACKAGE}/SPAT/IntersectionStatusObject.java
git checkout $BRANCH ${PACKAGE}/SPAT/ManeuverAssistList.java
git checkout $BRANCH ${PACKAGE}/SPAT/MovementEvent.java
git checkout $BRANCH ${PACKAGE}/SPAT/MovementEventList.java
git checkout $BRANCH ${PACKAGE}/SPAT/MovementList.java
git checkout $BRANCH ${PACKAGE}/SPAT/MovementPhaseState.java
git checkout $BRANCH ${PACKAGE}/SPAT/MovementState.java
git checkout $BRANCH ${PACKAGE}/SPAT/PedestrianBicycleDetect.java
git checkout $BRANCH ${PACKAGE}/SPAT/PedestrianBicycleDetectDeserializer.java
git checkout $BRANCH ${PACKAGE}/SPAT/SPAT.java
git checkout $BRANCH ${PACKAGE}/SPAT/SpeedAdvice.java
git checkout $BRANCH ${PACKAGE}/SPAT/TimeChangeDetails.java
git checkout $BRANCH ${PACKAGE}/SPAT/TimeIntervalConfidence.java
git checkout $BRANCH ${PACKAGE}/SPAT/TimeMark.java
git checkout $BRANCH ${PACKAGE}/SPAT/WaitOnStopline.java
git checkout $BRANCH ${PACKAGE}/SPAT/WaitOnStoplineDeserializer.java
git checkout $BRANCH ${PACKAGE}/SPAT/ZoneLength.java


git checkout $BRANCH ${PACKAGE}/SignalRequestMessage/DeltaTime.java
git checkout $BRANCH ${PACKAGE}/SignalRequestMessage/PriorityRequestType.java
git checkout $BRANCH ${PACKAGE}/SignalRequestMessage/RequestorDescription.java
git checkout $BRANCH ${PACKAGE}/SignalRequestMessage/RequestorPositionVector.java
git checkout $BRANCH ${PACKAGE}/SignalRequestMessage/SignalRequest.java
git checkout $BRANCH ${PACKAGE}/SignalRequestMessage/SignalRequestList.java
git checkout $BRANCH ${PACKAGE}/SignalRequestMessage/SignalRequestMessage.java
git checkout $BRANCH ${PACKAGE}/SignalRequestMessage/SignalRequestPackage.java
git checkout $BRANCH ${PACKAGE}/SignalRequestMessage/TransitVehicleOccupancy.java
git checkout $BRANCH ${PACKAGE}/SignalRequestMessage/TransitVehicleStatus.java


git checkout $BRANCH ${PACKAGE}/SignalStatusMessage/SignalRequesterInfo.java
git checkout $BRANCH ${PACKAGE}/SignalStatusMessage/SignalStatus.java
git checkout $BRANCH ${PACKAGE}/SignalStatusMessage/SignalStatusList.java
git checkout $BRANCH ${PACKAGE}/SignalStatusMessage/SignalStatusMessage.java
git checkout $BRANCH ${PACKAGE}/SignalStatusMessage/SignalStatusPackage.java
git checkout $BRANCH ${PACKAGE}/SignalStatusMessage/SignalStatusPackageList.java

############################################################################################# Part 2
